package coalstudio.coallobby.commands;

import coalstudio.coallobby.CoalLobby;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;


public class ReloadCommand implements CommandExecutor {

    private final CoalLobby instance = CoalLobby.getInstance();
    String prefix = ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("prefix"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("coallobby")) {
            FileConfiguration config = instance.getConfig();
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("help_message")));
                return true;
            }
            if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("coallobby.reload")){
                instance.reloadConfig();
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("reload")));
                return true;
            } else {
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_permission")));
            }
        } return false;
    }
}
