package fr.askyna.bot.commands;

import fr.askyna.bot.modules.ModuleBasee;

import java.util.HashMap;

public class CommandManager {
    protected HashMap<Class<? extends ModuleBasee>, Class<? extends Command>> ModuleCommandList = new HashMap<Class<? extends ModuleBasee>, Class<? extends Command>>();

    public CommandManager() {

    }

    public HashMap<Class<? extends ModuleBasee>, Class<? extends Command>> getModuleCommandList() {
        return ModuleCommandList;
    }

    public void addCommandtoModule(Class<? extends ModuleBasee> module, Class<? extends Command> command){
        ModuleCommandList.put(module, command);
    }
}