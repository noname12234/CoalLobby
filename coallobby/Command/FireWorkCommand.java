package vk.coalstudio.ru.coallobby.Command;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.meta.FireworkMeta;
import vk.coalstudio.ru.coallobby.CoalLobby;

import java.util.Random;

public class FireWorkCommand implements CommandExecutor, Listener {
	
	private final CoalLobby instance = CoalLobby.getInstance();
    String prefix = ChatColor.translateAlternateColorCodes('&', instance.getConfig().getString("prefix"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	FileConfiguration config = instance.getConfig();
        if (config.getBoolean("cmdfirework") == true) {
            if (!(sender instanceof Player) && command.getName().equalsIgnoreCase("firework")) {
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_console")));
                return true;
            }
            if (sender.hasPermission("coallobby.firework")) {
                Random random = new Random();
                Color color1 = Color.RED;
                int color = random.nextInt(16) + 1;
                if (color == 0) {
                    color1 = Color.RED;
                }
                if (color == 1) {
                    color1 = Color.RED;
                }
                if (color == 2) {
                    color1 = Color.BLUE;
                }
                if (color == 3) {
                    color1 = Color.GREEN;
                }
                if (color == 4) {
                    color1 = Color.BLACK;
                }
                if (color == 5) {
                    color1 = Color.PURPLE;
                }
                if (color == 6) {
                    color1 = Color.AQUA;
                }
                if (color == 7) {
                    color1 = Color.FUCHSIA;
                }
                if (color == 8) {
                    color1 = Color.LIME;
                }
                if (color == 9) {
                    color1 = Color.MAROON;
                }
                if (color == 10) {
                    color1 = Color.NAVY;
                }
                if (color == 11) {
                    color1 = Color.OLIVE;
                }
                if (color == 12) {
                    color1 = Color.ORANGE;
                }
                if (color == 13) {
                    color1 = Color.SILVER;
                }
                if (color == 14) {
                    color1 = Color.YELLOW;
                }
                if (color == 15) {
                    color1 = Color.TEAL;
                }
                if (color == 1) {
                    color1 = Color.WHITE;
                }
                Color color2 = Color.RED;
                int color3 = random.nextInt(16) + 1;
                if (color3 == 0) {
                    color2 = Color.RED;
                }
                if (color3 == 1) {
                    color2 = Color.RED;
                }
                if (color3 == 2) {
                    color2 = Color.BLUE;
                }
                if (color3 == 3) {
                    color2 = Color.GREEN;
                }
                if (color3 == 4) {
                    color2 = Color.BLACK;
                }
                if (color3 == 5) {
                    color2 = Color.PURPLE;
                }
                if (color3 == 6) {
                    color2 = Color.AQUA;
                }
                if (color3 == 7) {
                    color2 = Color.FUCHSIA;
                }
                if (color3 == 8) {
                    color2 = Color.LIME;
                }
                if (color3 == 9) {
                    color2 = Color.MAROON;
                }
                if (color3 == 10) {
                    color2 = Color.NAVY;
                }
                if (color3 == 11) {
                    color2 = Color.OLIVE;
                }
                if (color3 == 12) {
                    color2 = Color.ORANGE;
                }
                if (color3 == 13) {
                    color2 = Color.SILVER;
                }
                if (color3 == 14) {
                    color2 = Color.YELLOW;
                }
                if (color3 == 15) {
                    color2 = Color.TEAL;
                }
                if (color3 == 16) {
                    color2 = Color.WHITE;
                }
                if (color3 == 17) {
                    color2 = Color.WHITE;
                }
                int f2 = random.nextInt(4) + 1;
                FireworkEffect.Type f = FireworkEffect.Type.BALL_LARGE;
                if (f2 == 0) {
                    f = FireworkEffect.Type.BALL_LARGE;
                }
                if (f2 == 1) {
                    f = FireworkEffect.Type.BALL;
                }
                if (f2 == 2) {
                    f = FireworkEffect.Type.CREEPER;
                }
                if (f2 == 3) {
                    f = FireworkEffect.Type.STAR;
                }
                if (f2 == 4) {
                    f = FireworkEffect.Type.BURST;
                }
                if (f2 == 5) {
                    f = FireworkEffect.Type.STAR;
                }

                Firework firework = ((Player) sender).getPlayer().getWorld().spawn(((Player) sender).getLocation(), Firework.class);
                FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                data.addEffects(FireworkEffect.builder().withColor(color1).withColor(color2).with(f).withFlicker().build());
                data.setPower(1);
                firework.setFireworkMeta(data);
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("fireworkmsg")));
                return true;
            } else {
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_permission")));
                return true;
            }
        } else {
            sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', config.getString("no_activate")));
            return true;
        }
    }
}
