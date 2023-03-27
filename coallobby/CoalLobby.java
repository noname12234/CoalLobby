package vk.coalstudio.ru.coallobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import vk.coalstudio.ru.coallobby.Command.FireWorkCommand;
import vk.coalstudio.ru.coallobby.Command.FlyCommand;
import vk.coalstudio.ru.coallobby.Command.LightCommand;
import vk.coalstudio.ru.coallobby.Command.ReloadCommand;
import vk.coalstudio.ru.coallobby.Events.*;

import java.io.File;

public final class CoalLobby extends JavaPlugin {

    private static CoalLobby instance;
    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();
        this.getLogger().info("CoalLobby запущен");
        this.getLogger().info("Версия пагина: " + getDescription().getVersion());
        this.getLogger().info("Плагина разработан CoalStudio");
        this.getLogger().info("Студия - https://vk.com/coalstudio");
        this.getCommand("lighting").setExecutor(new LightCommand());
        this.getCommand("firework").setExecutor(new FireWorkCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("coallobby").setExecutor(new ReloadCommand());
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


