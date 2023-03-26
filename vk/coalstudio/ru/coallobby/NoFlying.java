package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class NoFlying implements Listener {
    @EventHandler
    public void nofly(PlayerMoveEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("no_fly_high") == true){
            Player p = e.getPlayer();
            int location = p.getLocation().getBlockY();
            Location spawn = p.getWorld().getSpawnLocation();
            if(location > CoalLobby.getInstance().getConfig().getInt("flyheight")) {
                p.teleport(spawn);
                if (CoalLobby.getInstance().getConfig().getBoolean("disable_fly_message") == false) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("no_fly_chat")));
                }
                if(CoalLobby.getInstance().getConfig().getBoolean("disable_fly_sound") == false){
                    p.playSound(p.getLocation(), Sound.valueOf(CoalLobby.getInstance().getConfig().getString("fly_sound")), 10, 1);
                }
                if(CoalLobby.getInstance().getConfig().getBoolean("disable_fly_title") == false){
                    p.sendTitle(CoalLobby.getInstance().getConfig().getString("no_fly_title").replace('&', '§'), CoalLobby.getInstance().getConfig().getString("no_fly_subtitle").replace('&', '§'), 10, 20, 10);
                }
                if (CoalLobby.getInstance().getConfig().getBoolean("disable_fly_bar") == false){
                    p.sendActionBar(CoalLobby.getInstance().getConfig().getString("no_fly_bar").replace('&', '§'));
                }
            }
        }
    }

}
