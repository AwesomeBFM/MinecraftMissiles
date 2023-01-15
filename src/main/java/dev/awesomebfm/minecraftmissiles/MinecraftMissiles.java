package dev.awesomebfm.minecraftmissiles;

import dev.awesomebfm.minecraftmissiles.commands.DebugCommand;
import dev.awesomebfm.minecraftmissiles.commands.DistanceCommand;
import dev.awesomebfm.minecraftmissiles.listeners.InventoryClickListener;
import dev.awesomebfm.minecraftmissiles.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftMissiles extends JavaPlugin {
    private static MinecraftMissiles instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getCommand("debug").setExecutor(new DebugCommand());
        getCommand("distance").setExecutor(new DistanceCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MinecraftMissiles getInstance() { return instance; }
}
