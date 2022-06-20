import fr.askyna.bot.modules.Module;
import fr.askyna.bot.modules.ModuleLoader;

public class TestModule extends Module {

    public static void main(String[] args) {
        aa();

        ModuleLoader.loadModules();
        System.out.println("Modules loaded!");


        ModuleLoader.unloadModules();
        System.out.println("Modules unloaded!");


    }

    public static void aa(){
        Module.getModules().add(TestModule.class);
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
