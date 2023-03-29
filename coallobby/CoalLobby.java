package coalstudio.coallobby;

import coalstudio.coallobby.events.*;
import coalstudio.coallobby.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginManager;

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

        logger.info("CoalLobby is enabled");
        logger.info("Version: " + getDescription().getVersion());
        logger.info("Plugin developed by ILeZzoV");

        getCommand("lighting").setExecutor(new LightCommand());
        getCommand("firework").setExecutor(new FireworkCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("coallobby").setExecutor(new ReloadCommand());
        getCommand("spit").setExecutor(new SpitCommand());

        pluginManager.registerEvents(new DamageOff(), this);
        pluginManager.registerEvents(new FoodOff(), this);
        pluginManager.registerEvents(new GamemodeTwo(), this);
        pluginManager.registerEvents(new NoFall(), this);
        pluginManager.registerEvents(new MessagesJoinServer(), this);
        pluginManager.registerEvents(new NoFlying(), this);
        pluginManager.registerEvents(new LevelJoin(), this);
        pluginManager.registerEvents(new FlyCommand(), this);
        pluginManager.registerEvents(new MessagesQuitServer(), this);

    }

    @Override
    public void onDisable() {
        logger.info("CoalLobby is disables");
        logger.info("Version: " + getDescription().getVersion());
        logger.info("Plugin developed by ILeZzoV");
    }

}
