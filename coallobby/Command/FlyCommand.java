package vk.coalstudio.ru.coallobby.Command;

import org.bukkit.*;
import org.bukkit.block.data.type.Bed;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.scheduler.BukkitRunnable;
import vk.coalstudio.ru.coallobby.CoalLobby;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlyCommand implements CommandExecutor, Listener {
    String prefix = CoalLobby.getInstance().getConfig().getString("prefix");
    public static List <UUID> toggled = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CoalLobby.getInstance().getConfig().getBoolean("cmdfly") == true) {
            if (!(sender instanceof Player) && command.getName().equalsIgnoreCase("fly")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_console")));
                return true;
            }
            Player player = (Player) sender;
            UUID id = player.getUniqueId();
            if (player.hasPermission("coallobby.fly")) {
                if (toggled.contains(id)) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    toggled.remove(id);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("fly_disabled")));
                    return true;
                } else if (!(toggled.contains(id))) {
                    player.setAllowFlight(true);
                    toggled.add(id);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("fly_enable")));
                    return true;
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_permission")));
                return true;
            }

        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_activate")));
            return true;
        }
        return false;
    }
    @EventHandler
    public void flighton(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE)
            return;
        if (toggled.contains(p.getUniqueId()))
            return;
        if(!(p.hasPermission("coallobby.double_jump")))
            return;
        e.setCancelled(true);
        p.setAllowFlight(false);
        p.setFlying(false);
        p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("double_message_chat")));
        p.playSound(p.getLocation(), Sound.valueOf(CoalLobby.getInstance().getConfig().getString("jump_sound")), 10, 1);
    }
    @EventHandler
    public void player(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if((p.getGameMode() != GameMode.CREATIVE) && (p.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR) && (!p.isFlying()) && (!toggled.contains(p.getUniqueId()))){
            p.setAllowFlight(true);
        }
    }
    @EventHandler
    public void particle(PlayerMoveEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("double_effect") == true){
            Player player = e.getPlayer();
            if(!(toggled.contains(player.getUniqueId())) && (player.getLocation().subtract(0,1,0).getBlock().getType() == Material.AIR) && (player.getGameMode() != GameMode.CREATIVE)){
                player.spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation(), 1);
            }
    }}
}

