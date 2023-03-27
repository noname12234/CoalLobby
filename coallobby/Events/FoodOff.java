package vk.coalstudio.ru.coallobby.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import vk.coalstudio.ru.coallobby.CoalLobby;

public class FoodOff implements Listener {
	
	private final CoalLobby instance = CoalLobby.getInstance();
	
    @EventHandler
    public void food(final FoodLevelChangeEvent e){
        if (!instance.getConfig().getBoolean("food")){
            e.setCancelled(true);
        }
    }
}
