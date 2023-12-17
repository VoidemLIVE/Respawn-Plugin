package net.greenwoodmc.respawnplugin;

import net.greenwoodmc.respawnplugin.commands.resplug;
import net.greenwoodmc.respawnplugin.listeners.damageListener;
import net.greenwoodmc.respawnplugin.tabcompleters.resplugTabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class RespawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RespawnPlugin Enabled");
        getLogger().info("Author: VoidemLIVE");
        getLogger().info("Version: " + getDescription().getVersion());
        int pluginId = 20509;
        new Metrics(this, pluginId);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("resplug").setExecutor(new resplug());
        getCommand("resplug").setTabCompleter(new resplugTabComplete());
        getServer().getPluginManager().registerEvents(new damageListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
