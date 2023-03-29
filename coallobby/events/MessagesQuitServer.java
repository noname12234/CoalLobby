package coalstudio.coallobby.events;

import coalstudio.coallobby.CoalLobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class MessagesQuitServer implements Listener {

    private final CoalLobby instance = CoalLobby.getInstance();

    public void quit(PlayerQuitEvent e) {
        FileConfiguration config = instance.getConfig();
        if (config.getBoolean("message_leave_server")) {
            Player p = e.getPlayer();
            Location loc = p.getLocation();
            if (config.getBoolean("disable_join_sound")){
                for(Player player: Bukkit.getOnlinePlayers()) {
                    player.playSound(loc, Sound.valueOf(config.getString("quit_sound")), 10, 1);
                }
            }
            if (config.getBoolean("disable_leave_message_global")) {
                e.setQuitMessage(null);
            } else if (!config.getBoolean("disable_leave_message_global")) {
                e.setQuitMessage(null);
                String mes = config.getString("quit_server_global");
                mes = mes.replace("{player}", p.getDisplayName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', mes));
            }
        }
    }
}