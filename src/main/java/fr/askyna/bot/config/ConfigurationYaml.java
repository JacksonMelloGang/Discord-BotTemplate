package fr.askyna.bot.config;

public class ConfigurationYaml {

    private String bot_token;
    private String bot_prefix;

    private String rethink_host;
    private String rethink_dbname;
    private int rethinkdb_port;

    public String getBot_token() {
        return bot_token;
    }

    public void setBot_token(String bot_token) {
        this.bot_token = bot_token;
    }

    public String getBot_prefix() {
        return bot_prefix;
    }

    public void setBot_prefix(String bot_prefix) {
        this.bot_prefix = bot_prefix;
    }

    public String getRethink_host() {
        return rethink_host;
    }

    public void setRethink_host(String rethink_host) {
        this.rethink_host = rethink_host;
    }

    public String getRethink_dbname() {
        return rethink_dbname;
    }

    public void setRethink_dbname(String rethink_dbname) {
        this.rethink_dbname = rethink_dbname;
    }

    public int getRethinkdb_port() {
        return rethinkdb_port;
    }

    public void setRethinkdb_port(int rethinkdb_port) {
        this.rethinkdb_port = rethinkdb_port;
    }

}
