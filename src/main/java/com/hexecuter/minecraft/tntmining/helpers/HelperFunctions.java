package com.hexecuter.minecraft.tntmining.helpers;

import com.hexecuter.minecraft.tntmining.TNTMining;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;

public class HelperFunctions {
    public static ArrayList<Block> getBlocksInLineOfSight(LivingEntity entity, int distance) {
        ArrayList<Block> blockList = new ArrayList<>();
        int counter = 0;
        for (Block currentBlock : entity.getLineOfSight(TNTMining.ALL_MATERIALS, distance)) {
            if (counter >= 2) {
                blockList.add(currentBlock);
            }
            counter++;
        }
        return blockList;
    }
}
