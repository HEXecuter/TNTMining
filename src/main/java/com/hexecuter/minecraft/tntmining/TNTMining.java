package com.hexecuter.minecraft.tntmining;

import com.hexecuter.minecraft.tntmining.listeners.TntLeftClickListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EnumSet;

public final class TNTMining extends JavaPlugin {
    public static TNTMining instance;
    public static EnumSet<Material> ALL_MATERIALS;

    @Override
    public void onEnable() {
        instance = this;
        ALL_MATERIALS = EnumSet.noneOf(Material.class);
        for (Material currentMaterial : Material.values()) {
            if (currentMaterial.isBlock()) {
                ALL_MATERIALS.add(currentMaterial);
            }
        }
        getServer().getPluginManager().registerEvents(new TntLeftClickListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
