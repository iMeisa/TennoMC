package com.meisa.tennomc.items;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.util.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;

public class Resources {

    public static final RegistryObject<Item> ALLOY_PLATE =
            Registration.ITEMS.register("alloy_plate",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)));

    public static final RegistryObject<Item> FERRITE =
            Registration.ITEMS.register("ferrite",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)));

    public static final RegistryObject<Item> NEURODE =
            Registration.ITEMS.register("neurode",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)
                            .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> RUBEDO =
            Registration.ITEMS.register("rubedo",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)));

    public static void register () {}

}
