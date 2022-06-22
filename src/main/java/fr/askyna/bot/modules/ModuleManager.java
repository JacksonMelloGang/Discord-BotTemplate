package fr.askyna.bot.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private static List<Class <? extends ModuleBase>> modules = new ArrayList<>();
    private static List<Class <? extends ModuleBase>> loaded_modules = new ArrayList<>();

    public static void loadModules() {
        for (Class<? extends ModuleBase> module : getModules()) {
            try {
                ModuleBase m = module.newInstance();
                m.onLoad();
                loaded_modules.add(m.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unloadModules() {
        for(int i = 0; i < getLoaded_modules().size(); i++){
            try {
                ModuleBase m = getLoaded_modules().get(i).newInstance();
                m.onUnload();
                loaded_modules.remove(m.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reloadModules() {
        for(int i = 0; i < getLoaded_modules().size(); i++) {
            try {
                ModuleBase m = getLoaded_modules().get(i).newInstance();
                m.onUnload();
                m.onLoad();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerModule(Class<? extends ModuleBase> module) {
        System.out.println("Registering module " + module.getName());
        try {
            ModuleBase m = module.newInstance();
            m.onLoad();
            loaded_modules.add(module);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unregisterModule(Class<? extends ModuleBase> module) {

        System.out.println("Unregistering module " + module.getName());
        try {
            ModuleBase m = module.newInstance();
            m.onUnload();
            loaded_modules.remove(module);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Class<? extends ModuleBase>> getModules() {
        return modules;
    }

    public static List<Class<? extends ModuleBase>> getLoaded_modules() {
        return loaded_modules;
    }


}
