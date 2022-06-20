package fr.askyna.bot.commands;

import fr.askyna.bot.Category;
import fr.askyna.bot.config.Config;
import fr.askyna.bot.modules.Module;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Command extends ListenerAdapter {

    protected HashMap<Class<?extends Module> , Class<? extends Command>> ModuleCommandList = new HashMap<>();

    public Class<?extends Module> module;
    public String name;
    public String description;
    public String usage;
    public Category category;
    public List<Permission> permissionNeeded = new ArrayList<>();
    public List<String> aliases = new ArrayList<>();

    public void Command(Class<? extends Module> module, String name, String description, String usage, Category category, ArrayList<Permission> permissionNeeded, ArrayList<String> aliases) {
        this.module = module;
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.category = category;
        this.permissionNeeded = permissionNeeded;
        this.aliases = aliases;

        ModuleCommandList.put(module, this.getClass());
    }

    public void Command(Class<? extends Module> module, String name, String description, String usage, Category category, ArrayList<Permission> permissionNeeded) {
        this.module = module;
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.category = category;
        this.permissionNeeded = null;

        ModuleCommandList.put(module, this.getClass());
    }

    public void Command(Class<? extends Module> module, String name, String description, String usage, Category category) {
        this.module = module;
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.category = category;
        this.aliases = Arrays.asList(name);

        ModuleCommandList.put(module, this.getClass());
    }

    public void Command(Class<? extends Module> module, String name, String description, String usage) {
        this.module = module;
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.category = Category.GENERAL;
        this.aliases = Arrays.asList(name);

        ModuleCommandList.put(module, this.getClass());
    }

    public void Command(Class<? extends Module> module, String name, String description) {
        this.module = module;
        this.name = name;
        this.description = description;
        this.usage = "No usage given";
        this.category = Category.GENERAL;
        this.permissionNeeded = null;
        this.aliases = Arrays.asList(name);


        ModuleCommandList.put(module, this.getClass());
    }

    public void Command(Class<? extends Module> module, String name) {
        this.module = module;
        this.name = name;
        this.description = "No description given";
        this.usage = "No usage given";
        this.category = Category.GENERAL;
        this.permissionNeeded = null;
        this.aliases = Arrays.asList(name);

        ModuleCommandList.put(module, this.getClass());
    }

    public abstract void execute(String[] args, String message, MessageReceivedEvent event);

    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    public Category getCategory() {
        return category;
    }


    public List<Permission> getPermissionNeeded() {
        return permissionNeeded;
    }

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;

        if(event.getMessage().getContentRaw().startsWith(Config.PREFIX)) {
            String[] args = event.getMessage().getContentRaw().split(" ");
            String message = event.getMessage().getContentRaw();
            execute(args, message, event);
        }
    }

    public boolean hasPermission(MessageReceivedEvent event) {
        if(this.permissionNeeded == null){
            if(event.getMember().hasPermission(Permission.MESSAGE_SEND)){
                return true;
            }
        } else {
            for (Permission permission : getPermissionNeeded()) {
                if (event.getMember().hasPermission(permission)){
                    return true;
                }
            }
        }

        return false;
    }
}
