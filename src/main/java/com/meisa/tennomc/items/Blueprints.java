package com.meisa.tennomc.items;

import com.meisa.tennomc.TennoMC;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;

public class Blueprints {

    private static final DeferredRegister<Item> BLUEPRINTS = DeferredRegister.create(ForgeRegistries.ITEMS, TennoMC.MOD_ID);


    private static final ResourceLocation ALLOY_PLATES = getModResourceLocation("alloy_plates");
    private static final ResourceLocation MORPHICS = getModResourceLocation("morphics");
    private static final ResourceLocation PLASTIDS = getModResourceLocation("plastids");
    private static final ResourceLocation SALVAGE = getModResourceLocation("salvage");

    private static final ResourceLocation SKANA = getModResourceLocation("skana");


    private static final List<Blueprint.Resource> SKANA_RESOURCES =
            Arrays.asList(
                    new Blueprint.Resource(SALVAGE, 75),
                    new Blueprint.Resource(PLASTIDS, 50),
                    new Blueprint.Resource(ALLOY_PLATES, 110),
                    new Blueprint.Resource(MORPHICS, 1)
            );
    public static final RegistryObject<Item> SKANA_BLUEPRINT =
            BLUEPRINTS.register("skana_blueprint",
                    () -> new Blueprint(new Item.Properties().tab(TennoMC.TAB_TENNO), 
                            SKANA_RESOURCES,
                            SKANA)
            );

    public static void register() { BLUEPRINTS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

    private static ResourceLocation getModResourceLocation(String resourceName) {
        return new ResourceLocation(TennoMC.MOD_ID, resourceName);
    }
}
