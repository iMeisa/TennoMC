package com.meisa.tennomc.common.items;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.common.lib.Blueprint;
import com.meisa.tennomc.common.lib.Resource;
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


    // Resources
    private static final ResourceLocation ALLOY_PLATES = getModResourceLocation("alloy_plates");
    private static final ResourceLocation MORPHICS = getModResourceLocation("morphics");
    private static final ResourceLocation PLASTIDS = getModResourceLocation("plastids");
    private static final ResourceLocation SALVAGE = getModResourceLocation("salvage");

    // Output Items
    private static final Resource SKANA = new Resource(getModResourceLocation("skana"));


    public static final RegistryObject<Item> BLUEPRINT =
            BLUEPRINTS.register("blueprint",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .stacksTo(16)));

    private static final List<Resource> SKANA_RESOURCES =
            Arrays.asList(
                    new Resource(SALVAGE, 75),
                    new Resource(PLASTIDS, 50),
                    new Resource(ALLOY_PLATES, 110),
                    new Resource(MORPHICS, 1)
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
