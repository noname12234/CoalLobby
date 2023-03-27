package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class GamemodeTwo implements Listener {
    @EventHandler
    public void onjoin(PlayerJoinEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("gamemodetwo") == true){
            Player player = e.getPlayer();
            player.setGameMode(GameMode.ADVENTURE);
        }
    }
}
