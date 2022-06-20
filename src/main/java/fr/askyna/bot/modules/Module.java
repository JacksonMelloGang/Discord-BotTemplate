package fr.askyna.bot.modules;

import fr.askyna.bot.commands.Command;

public abstract class Module {

    public abstract void onLoad();

    public abstract void onUnload();

    public void reload() {
        onUnload();
        onLoad();
    }

    public boolean registerCommand(Class<? extends Command> command){

        return false;
    }


}
