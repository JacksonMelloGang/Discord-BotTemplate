package fr.askyna.bot.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private static List<Class <? extends ModuleBasee>> modules = new ArrayList<>();
    private static List<Class <? extends ModuleBasee>> loaded_modules = new ArrayList<>();

    private static List<ModuleBase> aloaded_modules = new ArrayList<ModuleBase>();

    public static void loadModules() {
        for (Class<? extends ModuleBasee> module : getModules()) {
            try {
                ModuleBasee m = module.newInstance();
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

    @Deprecated
    public static void registerModule(Class<? extends ModuleBasee> module) {
        System.out.println("Registering module " + module.getName());
        try {
            ModuleBasee m = module.newInstance();
            m.onLoad();
            loaded_modules.add(module);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerModule(ModuleBase module) {
        System.out.println("Registering module " + module.getName());
        try {
            Module m = module.getClass().newInstance();
            m.onLoad();
            aloaded_modules.add(module);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
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
            aloaded_modules.remove(module);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Class<? extends ModuleBasee>> getModules() {
        return modules;
    }

    public static List<ModuleBase> getLoaded_modules() {
        return aloaded_modules;
    }


}
