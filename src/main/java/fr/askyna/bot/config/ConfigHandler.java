package fr.askyna.bot.config;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigHandler {

    public static void createconfigfile() throws IOException, URISyntaxException {
        File file = new File(Paths.get("").toAbsolutePath().toString() + File.separator +"data"+ File.separator +"config.yml");
        if(file.getParentFile().mkdirs()){
            file.createNewFile();
        } else {
            System.out.println("Couldn't create data folder, exiting...");
        }



    }
}
