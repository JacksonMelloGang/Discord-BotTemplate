package fr.askyna.bot.config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {

    private String filepath;

    private String bottoken;
    private String botprefix;

    private String rethinkip;
    private String rethinkdbname;
    private int rethinkdbport;


    public Config(String filepath) throws IOException {
        this.filepath = filepath;

        Yaml yaml = new Yaml();
        Config config = yaml.load(Files.newInputStream(Paths.get(System.getenv("os.dir") + "/config.yml")));
    }


    public static final String TOKEN = "";
    public static final String PREFIX = "!";

}
