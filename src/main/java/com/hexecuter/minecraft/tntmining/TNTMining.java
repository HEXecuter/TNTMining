package com.hexecuter.minecraft.tntmining;

import org.bukkit.plugin.java.JavaPlugin;

public final class TNTMining extends JavaPlugin {
    public static TNTMining instance;
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
