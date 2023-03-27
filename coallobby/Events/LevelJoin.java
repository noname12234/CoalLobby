package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class LevelJoin implements Listener {
    @EventHandler
    public void level(PlayerJoinEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("level") == true){
            Player p = e.getPlayer();
            p.setLevel(CoalLobby.getInstance().getConfig().getInt("level_amount"));
        }
    }
}
