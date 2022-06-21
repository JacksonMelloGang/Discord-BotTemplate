package fr.askyna.bot.commands;

import fr.askyna.bot.modules.Module;

import java.util.HashMap;

public class CommandManager {
    protected HashMap<Class<? extends Module>, Class<? extends Command>> ModuleCommandList = new HashMap<Class<? extends Module>, Class<? extends Command>>();

    public CommandManager() {

    }

    public HashMap<Class<? extends Module>, Class<? extends Command>> getModuleCommandList() {
        return ModuleCommandList;
    }

    public void addCommandtoModule(Class<? extends Module> module, Class<? extends Command> command){
        ModuleCommandList.put(module, command);
    }
}