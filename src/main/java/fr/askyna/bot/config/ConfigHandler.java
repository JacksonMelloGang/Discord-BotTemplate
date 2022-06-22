package fr.askyna.bot.config;

import java.io.*;
import java.nio.file.Paths;

public class ConfigHandler {

    public static void CreateConfigFolder() {
        File file = new File(Paths.get("").toAbsolutePath().toString() + File.separator +"data"+ File.separator +"config.yml");
        if(file.getParentFile().mkdirs()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Couldn't create data folder, exiting...");
        }
    }
}
