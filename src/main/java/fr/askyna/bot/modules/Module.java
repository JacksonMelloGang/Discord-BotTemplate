package fr.askyna.bot.modules;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {

    private static List<Class <? extends Module>> modules = new ArrayList<>();

    public abstract void onLoad();
    public abstract void onUnload();

    public static List<Class<? extends Module>> getModules() {
        return modules;
    }
}
