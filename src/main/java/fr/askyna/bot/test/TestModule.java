package fr.askyna.bot.test;

import fr.askyna.bot.modules.ModuleBase;

public class TestModule extends ModuleBase {


    public TestModule(String name, String description) {
        super(name, description);
    }

    @Override
    public void onLoad() {
        System.out.println("Module loaded");
    }

    @Override
    public void onUnload() {
        System.out.println("Unloading " + getName());
    }

}
