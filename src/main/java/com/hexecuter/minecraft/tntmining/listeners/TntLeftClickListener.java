package com.hexecuter.minecraft.tntmining.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TntLeftClickListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void TntLeftClick(PlayerInteractEvent event) {
        ItemStack itemInHand = event.getItem();

        boolean leftClickedOnBlock = event.getAction() == Action.LEFT_CLICK_BLOCK;
        boolean hasTntInHand = itemInHand.getType() == Material.TNT;

        if (!leftClickedOnBlock) return;
        if (!hasTntInHand) return;
    }
}
