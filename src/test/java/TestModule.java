import fr.askyna.bot.modules.ModuleBasee;

public class TestModule extends ModuleBasee {
    public TestModule() {
        super("ABC", "ABC_Description", "Askyna");
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
