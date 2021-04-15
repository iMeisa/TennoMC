package com.meisa.tennomc.items;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.util.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import org.lwjgl.system.CallbackI;

public class Resources {

    public static final RegistryObject<Item> ALLOY_PLATE =
            Registration.ITEMS.register("alloy_plate",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> FERRITE =
            Registration.ITEMS.register("ferrite",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> MORPHICS =
            Registration.ITEMS.register("morphics",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> NANO_SPORES =
            Registration.ITEMS.register("nano_spores",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> NEURODE =
            Registration.ITEMS.register("neurode",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> PLASTIDS =
            Registration.ITEMS.register("plastids",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> RUBEDO =
            Registration.ITEMS.register("rubedo",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SALVAGE =
            Registration.ITEMS.register("salvage",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.COMMON)));

    public static void register () {}

}
