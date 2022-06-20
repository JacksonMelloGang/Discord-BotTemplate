import fr.askyna.bot.Category;
import fr.askyna.bot.commands.Command;
import fr.askyna.bot.modules.Module;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Collections;

public class TestModuleCommand extends Command {

    public TestModuleCommand(Class<? extends Module> module, String name, String description, String usage, Category category, ArrayList<Permission> permissionNeeded, ArrayList<String> aliases) {
        super(TestModule.class, "test", "FJESZ0G", "grezogjezàprg", Category.GENERAL, null, null);
        System.out.println("RAGLA");
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
