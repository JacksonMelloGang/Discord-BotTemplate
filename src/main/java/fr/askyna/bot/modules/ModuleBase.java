package fr.askyna.bot.modules;

import fr.askyna.bot.commands.Command;

import java.util.List;

public class ModuleBase implements Module{

    private String name;
    private String description;
    private List<Command> command;

    public ModuleBase(String name, String description){
        this.name = name;
        this.description = description;
    }


    @Override
    public void onLoad() {

    }

    @Override
    public void onUnload() {

    }

    @Override
    public void onReload() {

    }

    @Override
    public void onRegister() {

    }

    @Override
    public void onUnregister() {

    }

    @Override
    public void getLogger() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Command> getCommand() {
        return command;
    }
}
