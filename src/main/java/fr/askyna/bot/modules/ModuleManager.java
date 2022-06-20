package fr.askyna.bot.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private static List<Class <? extends Module>> modules = new ArrayList<>();
    private static List<Class <? extends Module>> loaded_modules = new ArrayList<>();

    public static void loadModules() {
        for (Class<? extends Module> module : getModules()) {
            try {
                Module m = module.newInstance();
                m.onLoad();
                loaded_modules.add(m.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unloadModules() {
        for (Class<? extends Module> module : getModules()) {
            try {
                Module m = module.newInstance();
                m.onUnload();
                loaded_modules.remove(m.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reloadModules() {
        for (Class<? extends Module> module : getModules()) {
            try {
                Module m = module.newInstance();
                m.onUnload();
                m.onLoad();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addModules(Class<? extends Module> module) {
        modules.add(module);
    }

    public static void removeModules(Class<? extends Module> module) {
        modules.remove(module);
    }

    public static List<Class<? extends Module>> getModules() {
        return modules;
    }

    public static List<Class<? extends Module>> getRegisteredModule() {
        return loaded_modules;
    }


}
