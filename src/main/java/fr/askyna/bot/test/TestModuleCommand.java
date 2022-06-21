package fr.askyna.bot.test;

import fr.askyna.bot.Category;
import fr.askyna.bot.commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class TestModuleCommand extends Command {

    public TestModuleCommand(){
        this.module = TestModule.class;
        this.name = "AA";
        this.description = "BB";
    }

    @Override
    public void execute(String[] args, String message, MessageReceivedEvent event) {
        System.out.println("brrrr");
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public ArrayList<Permission> getPermissionNeeded() {
        return null;
    }

    @Override
    public ArrayList<String> getAliases() {
        return null;
    }
}
