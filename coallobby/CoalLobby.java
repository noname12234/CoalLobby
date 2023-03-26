package vk.coalstudio.ru.coallobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import vk.coalstudio.ru.coallobby.Command.FireWorkCommand;
import vk.coalstudio.ru.coallobby.Command.FlyCommand;
import vk.coalstudio.ru.coallobby.Command.LightCommand;
import vk.coalstudio.ru.coallobby.Events.*;

public final class CoalLobby extends JavaPlugin {

    private static CoalLobby instance;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        instance = this;

        /*File file = new File("plugins/CoalLobby");
        file.mkdir();*/

        this.getLogger().info("CoalLobby запущен");
        this.getLogger().info("Версия пагина: " + getDescription().getVersion());
        this.getLogger().info("Плагина разработан CoalStudio");
        this.getLogger().info("Студия - https://vk.com/coalstudio");
        this.getCommand("lighting").setExecutor(new LightCommand());
        this.getCommand("firework").setExecutor(new FireWorkCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new DamageOff(), this);
        Bukkit.getPluginManager().registerEvents(new FoodOff(), this);
        Bukkit.getPluginManager().registerEvents(new GamemodeTwo(), this);
        Bukkit.getPluginManager().registerEvents(new NoFall(), this);
        Bukkit.getPluginManager().registerEvents(new MessageJoinServer(), this);
        Bukkit.getPluginManager().registerEvents(new NoFlying(), this);
        Bukkit.getPluginManager().registerEvents(new LevelJoin(), this);
        Bukkit.getPluginManager().registerEvents(new FlyCommand(), this);
        Bukkit.getPluginManager().registerEvents(new MessageQuitServer(), this);

    }
    @Override
    public void onDisable() {
        this.getLogger().info("CoalLobby выключен");
        this.getLogger().info("Версия пагина: " + getDescription().getVersion());
        this.getLogger().info("Плагина разработан CoalStudio");
        this.getLogger().info("Студия - https://vk.com/coalstudios");
    }
    public static CoalLobby getInstance () {
        return instance;
    }
}


