package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.material.Coal;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class MessageJoinServer implements Listener {
    String prefix = CoalLobby.getInstance().getConfig().getString("prefix");

    @EventHandler
    public void joinserver(PlayerJoinEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("message_join_server") == true){
            Player p = e.getPlayer();
            Location loc = p.getLocation();
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_join_message") == false){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', CoalLobby.getInstance().getConfig().getString("join_server_chat")));
            }
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_title" )== false){
                p.sendTitle(CoalLobby.getInstance().getConfig().getString("join_server_title").replace('&', '§'), CoalLobby.getInstance().getConfig().getString("join_server_subtitle").replace('&', '§'), 10, 20, 10);
            }
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_join_bar") == false){
                p.sendActionBar('&',CoalLobby.getInstance().getConfig().getString("join_server_bar"));
            }
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_join_sound")){
                for(Player player: Bukkit.getOnlinePlayers()) {
                    player.playSound(loc, Sound.valueOf(CoalLobby.getInstance().getConfig().getString("join_sound")), 10, 1);
                }
            }
            if(CoalLobby.getInstance().getConfig().getBoolean("disable_join_message_global") == true){
                e.setJoinMessage(null);
            }else if(CoalLobby.getInstance().getConfig().getBoolean("disable_join_message_global") == false){
                e.setJoinMessage(null);
                String mes = CoalLobby.getInstance().getConfig().getString("join_server_global");
                mes = mes.replace("{player}", p.getDisplayName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', mes));
            }
 }else{
            e.setJoinMessage(null);
        }
}}