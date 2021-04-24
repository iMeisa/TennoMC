package com.meisa.tennomc.common.items;

import com.meisa.tennomc.TennoMC;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Resources {
    
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TennoMC.MOD_ID);

    public static final RegistryObject<Item> ALLOY_PLATES =
            ITEMS.register("alloy_plates",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> CIRCUITS =
            ITEMS.register("circuits",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> FERRITE =
            ITEMS.register("ferrite",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> MORPHICS =
            ITEMS.register("morphics",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> NANO_SPORES =
            ITEMS.register("nano_spores",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> NEURODE =
            ITEMS.register("neurode",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> PLASTIDS =
            ITEMS.register("plastids",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> POLYMER_BUNDLE =
            ITEMS.register("polymer_bundle",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> RUBEDO =
            ITEMS.register("rubedo",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SALVAGE =
            ITEMS.register("salvage",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

}
