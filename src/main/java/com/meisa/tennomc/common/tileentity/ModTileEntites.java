package com.meisa.tennomc.common.tileentity;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.common.blocks.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntites {

    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TennoMC.MOD_ID);

    public static final RegistryObject<TileEntityType<FoundryTile>> FOUNDRY_TILE_ENTITY =
            TILES.register("foundry_tile_entity", () -> TileEntityType.Builder.of(
                    () -> new FoundryTile(), ModBlocks.FOUNDRY.get()).build(null)
            );

    public static void register() { TILES.register(FMLJavaModLoadingContext.get().getModEventBus()); }
}
