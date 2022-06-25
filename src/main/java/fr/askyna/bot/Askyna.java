package fr.askyna.bot;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import fr.askyna.bot.config.ConfigHandler;
import fr.askyna.bot.modules.ModuleBase;
import fr.askyna.bot.modules.ModuleManager;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarFile;

public class Askyna {

    public static final RethinkDB r = RethinkDB.r;

    public static void main(String[] args) {

        if(args.length != 0){
            for(String s : args){
                if(s.equalsIgnoreCase("--console") || s.equalsIgnoreCase("-nogui")){
                    InitializeConsoleSetup();
                } else {
                    InitializeGUI();
                }
            }
        }

        //Connection conn = r.connection().hostname("localhost").port(28015).connect();
        //r.db("test").tableCreate("modules").run(conn);

        InitializeDataFolder();
        InitializePlugins();
        InitializeConsoleSetup();
    }

    private static void InitializeDataFolder() {
        FileNameExtensionFilter f = new FileNameExtensionFilter("Jar Files", "jar");
        // create a folder colled "data" if it doesn't exist
        if(!Files.exists(Paths.get(System.getProperty("user.dir") + "/data"))){
            try {
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/data"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // create a folder colled "data/modules" if it doesn't exist
        if(!Files.exists(Paths.get(System.getProperty("user.dir") + "/data/modules"))){
            try {
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/data/modules"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void InitializePlugins(){
        /**
         *         // get list of .jar files in the data folder
         *         // for each .jar file, load it and get the class that extends ModuleBase
         *         // add the class to the list of modules
         *         // for each class in the list of modules, create an instance of the class and call onLoad()
         **/

        try {
            for(Path s : Files.newDirectoryStream(Paths.get(System.getProperty("user.dir") + "/data/modules"), "*.jar")){
                JarFile jar = new JarFile(s.toString());

                for(String className : jar.getManifest().getMainAttributes().getValue("Main-Class").split(" ")){
                    Class<?> clazz = Class.forName(className.replace("/", ".").replace(".class", ""));
                    if(ModuleBase.class.isAssignableFrom(clazz)){
                        ModuleManager.registerModule((ModuleBase) clazz.newInstance());

                    }
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void InitializeConsoleSetup() {
        // User Input
        UserThreadInput userInput = new UserThreadInput();
        Thread Tui = new Thread(userInput);
        Tui.start();
    }

    private static void InitializeGUI(){

    }
}
