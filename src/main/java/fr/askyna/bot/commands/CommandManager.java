package fr.askyna.bot.commands;

import fr.askyna.bot.modules.ModuleBase;

import java.util.HashMap;

public class CommandManager {
    protected HashMap<Class<? extends ModuleBase>, Class<? extends Command>> ModuleCommandList = new HashMap<Class<? extends ModuleBase>, Class<? extends Command>>();

    public CommandManager() {

    }

    public HashMap<Class<? extends ModuleBase>, Class<? extends Command>> getModuleCommandList() {
        return ModuleCommandList;
    }

    public void addCommandtoModule(Class<? extends ModuleBase> module, Class<? extends Command> command){
        ModuleCommandList.put(module, command);
    }
}