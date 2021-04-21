package com.meisa.tennomc.world.gen;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.blocks.Deposits;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TennoMC.MOD_ID)
public class SurfaceDepositGeneration {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
        List<Supplier<ConfiguredFeature<?, ?>>> base = event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

        // Spawn Morphics

        final Set<Block> whitelist = new HashSet<>(Collections.singletonList(Blocks.SAND));
        final Set<BlockState> blacklist = new HashSet<>(Arrays.asList(Blocks.WATER.defaultBlockState(), Blocks.LAVA.defaultBlockState()));

        int morphicsTries = 16;
        int morphicsZSpread = 32;
        int morphicsYSpread = 32;
        int morphicsXSpread = 32;
        final BlockClusterFeatureConfig CONFIG = new BlockClusterFeatureConfig.Builder(
                new SimpleBlockStateProvider(Deposits.MORPHICS_DEPOSIT.get().defaultBlockState()),
                new SimpleBlockPlacer()
        )
                .whitelist(whitelist)
                .blacklist(blacklist)
                .tries(morphicsTries)
                .xspread(morphicsXSpread)
                .yspread(morphicsYSpread)
                .zspread(morphicsZSpread)
                .build();

        base.add(() -> Feature.RANDOM_PATCH.configured(CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    }
}
