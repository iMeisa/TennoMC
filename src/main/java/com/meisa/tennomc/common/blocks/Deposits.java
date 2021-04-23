package com.meisa.tennomc.common.blocks;

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

public class Deposits {
    
    private static final DeferredRegister<Block> DEPOSITS = DeferredRegister.create(ForgeRegistries.BLOCKS, TennoMC.MOD_ID);
    private static final DeferredRegister<Item> DEPOSIT_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TennoMC.MOD_ID);

    public static final RegistryObject<Block> ARGON_DEPOSIT = register("argon_deposit",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL)
                    .strength(5f)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> FERRITE_DEPOSIT = register("ferrite_deposit",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3f)
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> MORPHICS_DEPOSIT = register("morphics_deposit",
            () -> new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .instabreak()
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RUBEDO_DEPOSIT = register("rubedo_deposit",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3f)
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)));


    public static void register () {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DEPOSITS.register(eventBus);
        DEPOSIT_ITEMS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {

        RegistryObject<T> toReturn = DEPOSITS.register(name, block);
        DEPOSIT_ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(TennoMC.TAB_TENNO)));

        return toReturn;
    }
}
