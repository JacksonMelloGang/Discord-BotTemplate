package fr.askyna.bot.test;

import fr.askyna.bot.modules.ModuleBase;

public class TestModule extends ModuleBase {
    public TestModule() {
        super("ABC", "ABC_Description", "Askyna");
    }

    @Override
    public void onLoad() {
        System.out.println("ModuleBase loaded");
    }

    @Override
    public void onUnload() {
        System.out.println("Unloading " + this.getModulename());
    }


}
