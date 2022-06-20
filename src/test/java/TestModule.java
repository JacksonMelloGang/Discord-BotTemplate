import fr.askyna.bot.modules.Module;
import fr.askyna.bot.modules.ModuleManager;

public class TestModule extends Module {

    public static void main(String[] args) {
        ModuleManager.getModules().add(TestModule.class);

        ModuleManager.loadModules();
        System.out.println("Modules loaded!");

        ModuleManager.unloadModules();
        System.out.println("Modules unloaded!");

    }

    @Override
    public void onLoad() {
        System.out.println("Module loaded");
    }

    @Override
    public void onUnload() {
        System.out.println("Module unloaded");
    }

}
