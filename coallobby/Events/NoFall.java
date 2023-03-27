package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

import java.rmi.registry.LocateRegistry;


public class NoFall implements Listener {
    @EventHandler
    public void fall(PlayerMoveEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("no_falling_abyss") == true){
            Player p = e.getPlayer();
            int location = p.getLocation().getBlockY();
            Location spawn = p.getWorld().getSpawnLocation();
            if(location < CoalLobby.getInstance().getConfig().getInt("height")) {
                p.teleport(spawn);
                if(CoalLobby.getInstance().getConfig().getBoolean("disable_message") == false) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_fall_chat")));
                }
                if(CoalLobby.getInstance().getConfig().getBoolean("disable_sound") == false){
                    p.playSound(p.getLocation(), Sound.valueOf(CoalLobby.getInstance().getConfig().getString("fall_sound")), 10, 1);
                }
                if(CoalLobby.getInstance().getConfig().getBoolean("disable_title") == false){
                    p.sendTitle(CoalLobby.getInstance().getConfig().getString("no_fall_title").replace('&', '§'), CoalLobby.getInstance().getConfig().getString("no_fall_subtitle").replace('&', '§'), 10, 20, 10);
                }
                if (CoalLobby.getInstance().getConfig().getBoolean("disable_bar") == false){
                    p.sendActionBar(CoalLobby.getInstance().getConfig().getString("no_fall_bar").replace('&', '§'));
                }
            }
            }
        }
}

