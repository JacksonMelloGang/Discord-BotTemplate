package fr.askyna.bot.modules;
public class ModuleLoader {

    public static void loadModules() {
        for (Class<? extends Module> module : Module.getModules()) {
            try {
                Module m = module.newInstance();
                m.onLoad();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unloadModules() {
        for (Class<? extends Module> module : Module.getModules()) {
            try {
                Module m = module.newInstance();
                m.onUnload();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addModule(Class<? extends Module> module) {
        Module.getModules().add(module);
    }
}
