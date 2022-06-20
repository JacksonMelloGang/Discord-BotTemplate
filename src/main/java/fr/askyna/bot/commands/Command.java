package fr.askyna.bot.commands;

import fr.askyna.bot.Category;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class Command extends ListenerAdapter {

    public abstract void execute(String[] args, String message, MessageReceivedEvent event);

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getUsage();

    public abstract Category getCategory();

    public abstract ArrayList<Permission> getPermissionNeeded();

    public abstract ArrayList<String> getAliases();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        if(event.getMessage().getContentRaw().startsWith("a")) {
            String[] args = event.getMessage().getContentRaw().split(" ");
            String message = event.getMessage().getContentRaw();
            execute(args, message, event);
        }

        super.onMessageReceived(event);
    }
}
