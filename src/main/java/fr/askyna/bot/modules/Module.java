package fr.askyna.bot.modules;

public interface Module {

    public void onLoad();

    public void onUnload();

    public void onReload();

    public void onRegister();

    public void onUnregister();

    public void getLogger();

}
