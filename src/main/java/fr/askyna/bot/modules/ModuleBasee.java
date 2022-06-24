package fr.askyna.bot.modules;

import fr.askyna.bot.commands.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ModuleBasee {

    private final String modulename;
    private final String moduledescription;
    private final int moduleid;
    private final String moduleAuthor;
    private final List<Class<? extends Command>> commands_list = new ArrayList<>();
    private final List<Class<? extends Command>> enabled_commands = new ArrayList<>();


    public abstract void onLoad();

    public abstract void onUnload();

    public void reload() {
        onUnload();
        onLoad();
    }

    public ModuleBasee(String name, String description, String author){
        this.modulename = name;
        this.moduledescription = description;
        this.moduleAuthor = author;
        this.moduleid = name.hashCode();
    }

    public ModuleBasee(String name, String description){
        this.modulename = name;
        this.moduledescription = description;
        this.moduleAuthor = "No Author given";
        this.moduleid = name.hashCode();
    }

    public ModuleBasee(String name){
        this.modulename = name;
        this.moduledescription = "No description given";
        this.moduleAuthor = "No Author given";
        this.moduleid = name.hashCode();
    }

    public boolean registerCommand(Class<? extends Command> command){

        return false;
    }

    public List<String> getModuleInfos(){
        return Arrays.asList(modulename, moduledescription, moduleAuthor, String.valueOf(moduleid));
    }

    public int getModuleid() {
        return moduleid;
    }

    public String getModuleAuthor() {
        return moduleAuthor;
    }

    public String getModuledescription() {
        return moduledescription;
    }

    public String getModulename() {
        return modulename;
    }

    protected List<Class<? extends Command>> getCommands_list() {
        return commands_list;
    }

    public List<Class<? extends Command>> getEnabled_commands() {
        return enabled_commands;
    }


}
