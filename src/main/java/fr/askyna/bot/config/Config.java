package fr.askyna.bot.config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {

    private String filepath;
    public static Yaml yaml = new Yaml();
    public static final String TOKEN = "";
    public static final String PREFIX = "!";


    public Config(String filepath) throws IOException {
        this.filepath = filepath;



        ConfigurationYaml config = yaml.load(Files.newInputStream(Paths.get(System.getenv("os.dir") + "/config.yml")));
    }



}
