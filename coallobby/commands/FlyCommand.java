package coalstudio.coallobby.commands;

import coalstudio.coallobby.CoalLobby;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlyCommand implements CommandExecutor, Listener {

    private final CoalLobby instance = CoalLobby.getInstance();
    String prefix = ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("prefix"));
    public static List <UUID> toggled = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = instance.getConfig();
        if (config.getBoolean("cmdfly")) {
            if (!(sender instanceof Player) && command.getName().equalsIgnoreCase("fly")) {
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_console")));
                return true;
            }
            Player player = (Player) sender;
            UUID id = player.getUniqueId();
            if (player.hasPermission("coallobby.fly")) {
                if (toggled.contains(id)) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    toggled.remove(id);
                    player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("fly_disabled")));
                    return true;
                } else if (!(toggled.contains(id))) {
                    player.setAllowFlight(true);
                    toggled.add(id);
                    player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("fly_enable")));
                    return true;
                }
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

    @EventHandler
    public void flighton(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE)
            return;
        if (toggled.contains(p.getUniqueId()))
            return;
        if(!(p.hasPermission("coallobby.double_jump")))
            return;
        FileConfiguration config = instance.getConfig();
        e.setCancelled(true);
        p.setAllowFlight(false);
        p.setFlying(false);
        p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("double_message_chat")));
        p.playSound(p.getLocation(), Sound.valueOf(config.getString("jump_sound")), 10, 1);
    }

    @EventHandler
    public void player(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if ((p.getGameMode() != GameMode.CREATIVE) && (p.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR) && (!p.isFlying()) && (!toggled.contains(p.getUniqueId()))) {
            p.setAllowFlight(true);
        }
    }

    @EventHandler
    public void particle(PlayerMoveEvent e) {
        FileConfiguration config = instance.getConfig();
        if (config.getBoolean("double_effect")) {
            Player player = e.getPlayer();
            if (!(toggled.contains(player.getUniqueId())) && (player.getLocation().subtract(0,1,0).getBlock().getType() == Material.AIR) && (player.getGameMode() != GameMode.CREATIVE)) {
                player.spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation(), 1);
            }
        }
    }
}