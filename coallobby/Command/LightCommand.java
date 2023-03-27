package vk.coalstudio.ru.coallobby.Command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class LightCommand implements CommandExecutor, Listener {

	private final CoalLobby instance = CoalLobby.getInstance();
    String prefix = ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("prefix"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	FileConfiguration config = instance.getConfig();
        if (config.getBoolean("cmdlighting")) {
            if (!(sender instanceof Player) && command.getName().equalsIgnoreCase("lighting")) {
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_console")));
                return true;
            }
            Player player = (Player) sender;
            if (player.hasPermission("coallobby.lighting")){
                player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("lightmsg")));
                Location location = player.getLocation();
                World world = player.getWorld();
                world.strikeLightning(location);

            } else {
                player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_permission")));
                return true;
            }

        } else {
            sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_activate")));
            return true;
        }
        return false;
    }
}
