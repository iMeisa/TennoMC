package com.meisa.tennomc.world;

import com.meisa.tennomc.blocks.ModBlocks;
import net.minecraft.block.Block;

import javax.annotation.Nullable;


/*
***
*** Update this for ore generation
***
 */

public enum OreType {

    FERRITE(ModBlocks.FERRITE_DEPOSIT.get(), 20, 20, 90);


    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;


    OreType(Block block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Block getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    @Nullable
    public static OreType get(Block block) {
        for(OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }

        return null;
    }
}
