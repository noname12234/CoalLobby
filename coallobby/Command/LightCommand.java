package vk.coalstudio.ru.coallobby.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class LightCommand implements CommandExecutor, Listener {

    String prefix = CoalLobby.getInstance().getConfig().getString("prefix");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CoalLobby.getInstance().getConfig().getBoolean("cmdlighting") == true) {
            if (!(sender instanceof Player) && command.getName().equalsIgnoreCase("lighting")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_console")));
                return true;
            }
            Player player = (Player) sender;
            if (player.hasPermission("coallobby.lighting")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("lightmsg")));
                Location location = player.getLocation();
                World world = player.getWorld();
                world.strikeLightning(location);

            }else{
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_permission")));
                return true;
            }

        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_activate")));
            return true;
        }
        return false;
    }
}
