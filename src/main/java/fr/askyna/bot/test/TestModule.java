package fr.askyna.bot.test;

import fr.askyna.bot.modules.Module;

public class TestModule extends Module {
    public TestModule() {
        super("ABC", "ABC_Description", "Askyna");
    }

    @Override
    public void onLoad() {
        System.out.println("Module loaded");
    }

    @Override
    public void onUnload() {
        System.out.println("Unloading " + this.getModulename());
    }


}
