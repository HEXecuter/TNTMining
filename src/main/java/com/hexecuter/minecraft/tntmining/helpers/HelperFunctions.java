package com.hexecuter.minecraft.tntmining.helpers;

import com.hexecuter.minecraft.tntmining.TNTMining;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.EnumSet;

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

    public static void removeBlocks(Block block, EnumSet<Material> blocksToBreak, int radius) {
        int endingX = block.getX() + radius;
        int endingY = block.getY() + radius + radius;
        int endingZ = block.getZ() + radius;

        for (int startingX = block.getX() - radius; startingX < endingX; startingX++){
            for(int startingY = block.getY() - 1; startingY < endingY; startingY++) {
                for (int startingZ = block.getZ() - radius; startingZ < endingZ; startingZ++) {
                    Block currentBlock = block.getWorld().getBlockAt(startingX, startingY, startingZ);
                    if (!currentBlock.getType().isAir() && blocksToBreak.contains(currentBlock.getType())) {
                        currentBlock.setType(Material.AIR);
                    }
                }
            }
        }
    }

    public static void createExplosions(Location location, int count) {
        World world = location.getWorld();
        world.spawnParticle(Particle.EXPLOSION_HUGE, location, count, 3, 0, 3);
        world.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
    }
}
