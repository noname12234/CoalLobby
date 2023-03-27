package vk.coalstudio.ru.coallobby.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import vk.coalstudio.ru.coallobby.CoalLobby;
import vk.coalstudio.ru.coallobby.CoalLobby.*;

public class ReloadCommand implements CommandExecutor {
    String prefix = CoalLobby.getInstance().getConfig().getString("prefix");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("coallobby")) {
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                String mes = ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("help_message"));
                mes.replace("{prefix}", prefix);
                sender.sendMessage(mes);
                return true;
            }
            if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("coallobby.reload")){
                CoalLobby.getInstance().reloadConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("reload")));
                return true;
            }else{
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_permission")));
            }
        } return false;
    }
}
