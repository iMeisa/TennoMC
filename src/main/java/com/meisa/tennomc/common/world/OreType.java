package com.meisa.tennomc.common.world;

import com.meisa.tennomc.common.blocks.Deposits;
import net.minecraft.block.Block;
import net.minecraft.world.gen.GenerationStage;

import javax.annotation.Nullable;


/*
***
*** Update this for ore generation
***
 */

public enum OreType {

    ARGON(Deposits.ARGON_DEPOSIT.get(), 1, 50, 256, GenerationStage.Decoration.VEGETAL_DECORATION),
    FERRITE(Deposits.FERRITE_DEPOSIT.get(), 15, 20, 80, GenerationStage.Decoration.UNDERGROUND_ORES),
    RUBEDO(Deposits.RUBEDO_DEPOSIT.get(), 8, 15, 75, GenerationStage.Decoration.UNDERGROUND_ORES);


    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final GenerationStage.Decoration decoration;


    OreType(Block block, int maxVeinSize, int minHeight, int maxHeight, GenerationStage.Decoration decoration) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.decoration = decoration;
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

    public GenerationStage.Decoration getDecoration() {
        return decoration;
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
