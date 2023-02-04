package com.hexecuter.minecraft.tntmining.listeners;

import com.hexecuter.minecraft.tntmining.TNTMining;
import com.hexecuter.minecraft.tntmining.helpers.HelperFunctions;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class TntLeftClickListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void TntLeftClick(PlayerInteractEvent event) {
        ItemStack itemInHand = event.getItem();
        Player player = event.getPlayer();

        boolean leftClickedOnBlock = event.getAction() == Action.LEFT_CLICK_BLOCK;
        boolean hasTntInHand = itemInHand != null && itemInHand.getType() == Material.TNT;

        if (!leftClickedOnBlock) return;
        if (!hasTntInHand) return;

        ArrayList<Block> lineOfBlocksToBreak = HelperFunctions.getBlocksInLineOfSight(player, 30);
        for (int i = 0; i < lineOfBlocksToBreak.size(); i++) {
            if (i % 10 == 0) {
                HelperFunctions.removeBlocks(lineOfBlocksToBreak.get(i), TNTMining.BLOCKS_TO_BREAK, 5);
                HelperFunctions.createExplosions(lineOfBlocksToBreak.get(i).getLocation(), 3);
            }
        }
        itemInHand.setAmount(itemInHand.getAmount() - 1);
    }
}
