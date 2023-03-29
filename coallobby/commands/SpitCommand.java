package coalstudio.coallobby.commands;

import coalstudio.coallobby.CoalLobby;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpitCommand implements CommandExecutor {

    private final CoalLobby instance = CoalLobby.getInstance();
    String prefix = ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("prefix"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = instance.getConfig();
        if (config.getBoolean("cmdspit")) {
            if (!(sender instanceof Player) && command.getName().equalsIgnoreCase("spit")) {
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_console")));
                return true;
            }
            Player player = (Player) sender;
            if (player.hasPermission("coallobby.spit")){
                player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("spit")));
                final Location location = player.getLocation().toVector().add(player.getLocation().getDirection().multiply(0.8)).toLocation(player.getWorld()).add(0.0, 1.0, 0.0);
                final Entity spitmonster = player.getWorld().spawnEntity(location, EntityType.LLAMA_SPIT);
                spitmonster.setVelocity(player.getEyeLocation().getDirection().multiply(1));

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
