package com.meisa.tennomc.blocks;

import com.meisa.tennomc.TennoMC;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TennoMC.MOD_ID);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TennoMC.MOD_ID);

    public static final RegistryObject<Block> FOUNDRY = register("foundry",
            () -> new Foundry(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .strength(4f)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.ANVIL)));


    public static void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {

        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        BLOCK_ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(TennoMC.TAB_TENNO)));

        return toReturn;
    }
}
