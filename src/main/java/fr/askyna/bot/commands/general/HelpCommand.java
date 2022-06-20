package fr.askyna.bot.commands.general;

import fr.askyna.bot.Category;
import fr.askyna.bot.commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class HelpCommand extends Command {
    @Override
    public void execute(String[] args, String message, MessageReceivedEvent event) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public Category getCategory() {
        return Category.GENERAL;
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
