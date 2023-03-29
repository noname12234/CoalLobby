package coalstudio.coallobby.events;

import coalstudio.coallobby.CoalLobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class FoodOff implements Listener {

    private final CoalLobby instance = CoalLobby.getInstance();

    @EventHandler
    public void food(final FoodLevelChangeEvent e){
        if (!instance.getConfig().getBoolean("food")){
            e.setCancelled(true);
        }
    }
}