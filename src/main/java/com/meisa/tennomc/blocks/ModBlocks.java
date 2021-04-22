package com.meisa.tennomc.blocks;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> FOUNDRY = register("foundry",
            () -> new Foundry(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .strength(4f)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.ANVIL)));


    public static void register() {}

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {

        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(TennoMC.TAB_TENNO)));

        return toReturn;
    }
}
