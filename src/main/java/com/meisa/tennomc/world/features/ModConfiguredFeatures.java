package com.meisa.tennomc.world.features;

import com.meisa.tennomc.blocks.Deposits;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> ARGON_SPAWN =
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,"argon_spawn", Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Deposits.ARGON_DEPOSIT.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE));
}
