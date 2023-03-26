package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class MessageQuitServer implements Listener {
    public void quit(PlayerQuitEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("message_leave_server") == true){
            Player p = e.getPlayer();
            Location loc = p.getLocation();
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_join_sound")){
                for(Player player: Bukkit.getOnlinePlayers()) {
                    player.playSound(loc, Sound.valueOf(CoalLobby.getInstance().getConfig().getString("quit_sound")), 10, 1);
                }
            }
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_leave_message_global") == true){
                e.setQuitMessage(null);
            }else if(CoalLobby.getInstance().getConfig().getBoolean("disable_leave_message_global") == false){
                e.setQuitMessage(null);
                String mes = CoalLobby.getInstance().getConfig().getString("quit_server_global");
                mes = mes.replace("{player}", p.getDisplayName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', mes));
            }
        }else{
        }
    }
}
