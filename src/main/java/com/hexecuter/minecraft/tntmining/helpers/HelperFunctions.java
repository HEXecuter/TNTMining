package com.hexecuter.minecraft.tntmining.helpers;

import com.hexecuter.minecraft.tntmining.TNTMining;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;

public class HelperFunctions {
    public static ArrayList<Block> getBlocksInLineOfSight(LivingEntity entity, int distance) {
        ArrayList<Block> blockList = new ArrayList<>();
        int counter = 0;
        for (Block currentBlock : entity.getLineOfSight(TNTMining.ALL_BLOCKS, distance)) {
            if (counter >= 2) {
                blockList.add(currentBlock);
            }
            counter++;
        }
        return blockList;
    }

    public static void removeBlocks(Block block, int radius) {
        int endingX = block.getX() + radius;
        int endingY = block.getY() + radius;
        int endingZ = block.getZ() + radius;

        for (int startingX = block.getX() - radius; startingX < endingX; startingX++){
            for(int startingY = block.getY() - radius; startingY < endingY; startingY++) {
                for (int startingZ = block.getZ() - radius; startingZ < endingZ; startingZ++) {
                    Block currentBlock = block.getWorld().getBlockAt(startingX, startingY, startingZ);
                    if (TNTMining.BLOCKS_TO_BREAK.contains(currentBlock.getType())) {
                        currentBlock.breakNaturally();
                    }
                }
            }
        }
    }
}
