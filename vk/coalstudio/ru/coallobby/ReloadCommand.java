package vk.coalstudio.ru.coallobby.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.material.Coal;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class ReloadCommand implements CommandExecutor {
    String prefix = CoalLobby.getInstance().getConfig().getString("prefix");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("coallobby")) {
            if(args.length >0) {
                if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("coallobby.reload")){
                CoalLobby.getInstance().saveConfig();
                CoalLobby.getInstance().reloadConfig();
                CoalLobby.getInstance().saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("reload")));
                return true;
            }sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_permission")));
                return true;
            }
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_permission")));
            return true;
        } return false;
}}
