package fr.askyna.bot;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import fr.askyna.bot.config.ConfigHandler;
import fr.askyna.bot.modules.ModuleManager;
import fr.askyna.bot.test.TestModule;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Askyna {

    public static final RethinkDB r = RethinkDB.r;

    public static void main(String[] args) {


        ConfigHandler.CreateConfigFolder();


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

        ModuleManager.registerModule(TestModule.class);

        InitializeFolders();
        InitializeConsoleSetup();
    }

    private static void InitializeFolders() {
        FileNameExtensionFilter f = new FileNameExtensionFilter("Jar Files", "jar");
        
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
