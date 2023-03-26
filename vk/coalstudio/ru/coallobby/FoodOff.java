package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class FoodOff implements Listener {
    @EventHandler
    public void food(final FoodLevelChangeEvent e){
        if(CoalLobby.getInstance().getConfig().getBoolean("food") == false){
                e.setCancelled(true);
        }
    }
}
