package vk.coalstudio.ru.coallobby;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import vk.coalstudio.ru.coallobby.Command.FireWorkCommand;
import vk.coalstudio.ru.coallobby.Command.FlyCommand;
import vk.coalstudio.ru.coallobby.Command.LightCommand;
import vk.coalstudio.ru.coallobby.Command.ReloadCommand;
import vk.coalstudio.ru.coallobby.Events.*;

public final class CoalLobby extends JavaPlugin {

    private static CoalLobby instance;
    
    public static CoalLobby getInstance() {
        return instance;
    }
    
    private final PluginManager pluginManager = getServer().getPluginManager();
    
    private final Logger logger = getLogger();
    
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        logger.info("CoalLobby запущен");
        logger.info("Версия пагина: " + getDescription().getVersion());
        logger.info("Плагина разработан CoalStudio");
        logger.info("Студия - https://vk.com/coalstudio");
        getCommand("lighting").setExecutor(new LightCommand());
        getCommand("firework").setExecutor(new FireWorkCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("coallobby").setExecutor(new ReloadCommand());
        pluginManager.registerEvents(new DamageOff(), this);
        pluginManager.registerEvents(new FoodOff(), this);
        pluginManager.registerEvents(new GamemodeTwo(), this);
        pluginManager.registerEvents(new NoFall(), this);
        pluginManager.registerEvents(new MessageJoinServer(), this);
        pluginManager.registerEvents(new NoFlying(), this);
        pluginManager.registerEvents(new LevelJoin(), this);
        pluginManager.registerEvents(new FlyCommand(), this);
        pluginManager.registerEvents(new MessageQuitServer(), this);

    }
    
    @Override
    public void onDisable() {
    	logger.info("CoalLobby выключен");
    	logger.info("Версия пагина: " + getDescription().getVersion());
    	logger.info("Плагина разработан CoalStudio");
    	logger.info("Студия - https://vk.com/coalstudios");
    }

}


