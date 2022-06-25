package fr.askyna.bot.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private static List<ModuleBase> modules = new ArrayList<>();
   private static List<ModuleBase> loaded_modules = new ArrayList<ModuleBase>();

    public static void loadModules() {
        for(ModuleBase module : getModules()) {
            try {
                ModuleBase m = module.getClass().newInstance();
                m.onLoad();
                loaded_modules.add(module);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unloadModules() {
        for(int i = 0; i < getLoaded_modules().size(); i++){
            try {
                Module m = getLoaded_modules().get(i).getClass().newInstance();
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
                Module m = getLoaded_modules().get(i).getClass().newInstance();
                m.onUnload();
                m.onLoad();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerModule(ModuleBase module) {
        System.out.println("Registering module " + module.getName());
        try {
            loaded_modules.add(module);
            Module m = module.getClass().newInstance();
            m.onLoad();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unregisterModule(Class<? extends ModuleBasee> module) {

        System.out.println("Unregistering module " + module.getName());
        try {
            ModuleBasee m = module.newInstance();
            m.onUnload();
            loaded_modules.remove(module);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static void unregisterModule(ModuleBase module) {
        System.out.println("Unregistering module " + module.getName());
        try {
            Module m = module.getClass().newInstance();
            m.onUnload();
            loaded_modules.remove(module);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ModuleBase> getModules() {
        return modules;
    }

    public static List<ModuleBase> getLoaded_modules() {
        return loaded_modules;
    }


}
