package com.hexecuter.minecraft.tntmining;

import com.hexecuter.minecraft.tntmining.listeners.TntLeftClickListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EnumSet;

public final class TNTMining extends JavaPlugin {
    public static TNTMining instance;
    public static EnumSet<Material> ALL_BLOCKS;
    public static EnumSet<Material> BLOCKS_TO_BREAK;

    @Override
    public void onEnable() {
        instance = this;

        ALL_BLOCKS = EnumSet.noneOf(Material.class);
        for (Material currentMaterial : Material.values()) {
            if (currentMaterial.isBlock()) {
                ALL_BLOCKS.add(currentMaterial);
            }
        }

        populateBlocksToBreak();

        getServer().getPluginManager().registerEvents(new TntLeftClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // TODO: eventually change this to loading in a config file
    public static void populateBlocksToBreak() {
        BLOCKS_TO_BREAK = EnumSet.noneOf(Material.class);
        BLOCKS_TO_BREAK.add(Material.COARSE_DIRT);
        BLOCKS_TO_BREAK.add(Material.DIRT);
        BLOCKS_TO_BREAK.add(Material.DIRT_PATH);
        BLOCKS_TO_BREAK.add(Material.ROOTED_DIRT);
        BLOCKS_TO_BREAK.add(Material.COBBLESTONE);
        BLOCKS_TO_BREAK.add(Material.COBBLED_DEEPSLATE);
        BLOCKS_TO_BREAK.add(Material.DEEPSLATE);
        BLOCKS_TO_BREAK.add(Material.SAND);
        BLOCKS_TO_BREAK.add(Material.SANDSTONE);
        BLOCKS_TO_BREAK.add(Material.STONE);
        BLOCKS_TO_BREAK.add(Material.GRAVEL);
        BLOCKS_TO_BREAK.add(Material.PODZOL);
        BLOCKS_TO_BREAK.add(Material.RED_SAND);
        BLOCKS_TO_BREAK.add(Material.RED_SANDSTONE);
        BLOCKS_TO_BREAK.add(Material.DIORITE);
        BLOCKS_TO_BREAK.add(Material.CLAY);
        BLOCKS_TO_BREAK.add(Material.ANDESITE);
        BLOCKS_TO_BREAK.add(Material.BLACK_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.BLUE_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.BROWN_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.CYAN_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.GRAY_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.GREEN_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.LIGHT_BLUE_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.LIGHT_GRAY_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.LIME_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.MAGENTA_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.ORANGE_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.PINK_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.PURPLE_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.RED_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.WHITE_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.YELLOW_TERRACOTTA);
        BLOCKS_TO_BREAK.add(Material.WATER);
        BLOCKS_TO_BREAK.add(Material.LAVA);
        BLOCKS_TO_BREAK.add(Material.NETHERRACK);
        BLOCKS_TO_BREAK.add(Material.GRANITE);
        BLOCKS_TO_BREAK.add(Material.GRASS_BLOCK);
        BLOCKS_TO_BREAK.add(Material.TUFF);
    }
}
