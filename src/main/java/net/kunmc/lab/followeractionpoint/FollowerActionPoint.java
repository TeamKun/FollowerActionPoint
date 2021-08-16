package net.kunmc.lab.followeractionpoint;

import net.kunmc.lab.followeractionpoint.follower.FollowerMap;
import org.bukkit.plugin.java.JavaPlugin;

public final class FollowerActionPoint extends JavaPlugin {

    public static FollowerActionPoint plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        new FollowerMap();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}