package com.meisa.tennomc.items;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> FERRITE =
            Registration.ITEMS.register("ferrite",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)));

    public static final RegistryObject<Item> RUBEDO =
            Registration.ITEMS.register("rubedo",
                    () -> new Item(new Item.Properties()
                            .tab(TennoMC.TAB_TENNO)));

    public static void register () {}

}
