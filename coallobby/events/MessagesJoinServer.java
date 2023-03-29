package coalstudio.coallobby.events;

import coalstudio.coallobby.CoalLobby;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MessagesJoinServer implements Listener {

    private final CoalLobby instance = CoalLobby.getInstance();

    @EventHandler
    public void joinserver(PlayerJoinEvent e) {
        FileConfiguration config = instance.getConfig();
        if (config.getBoolean("message_join_server")) {
            Player p = e.getPlayer();
            Location loc = p.getLocation();
            if (!config.getBoolean("disable_join_message")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("join_server_chat")));
            }
            if (!config.getBoolean("disable_title" )) {
                p.sendTitle(ChatColor.translateAlternateColorCodes('&', config.getString("join_server_title")), ChatColor.translateAlternateColorCodes('&', config.getString("join_server_subtitle")), 10, 20, 10);
            }
            if (!config.getBoolean("disable_join_bar")) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', config.getString("join_server_bar"))));
            }
            if (config.getBoolean("disable_join_sound")){
                for (Player player: Bukkit.getOnlinePlayers()) {
                    player.playSound(loc, Sound.valueOf(config.getString("join_sound")), 10, 1);
                }
            }

            if (config.getBoolean("disable_join_message_global") == true) {
                e.setJoinMessage(null);
            } else if (config.getBoolean("disable_join_message_global") == false) {
                e.setJoinMessage(null);
                String mes = config.getString("join_server_global");
                mes = mes.replace("{player}", p.getDisplayName());
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', mes));
            }
        } else {
            e.setJoinMessage(null);
        }
    }
}
