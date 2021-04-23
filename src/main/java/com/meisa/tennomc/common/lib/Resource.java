package com.meisa.tennomc.common.lib;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class Resource {
    public final ResourceLocation resourceLocation;
    public int amount = 1;

    public Resource(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public Resource(ResourceLocation resourceLocation, int amount) {
        this.resourceLocation = resourceLocation;
        this.amount = amount;
    }

    public Item asItem() {
        return Registry.ITEM.get(this.resourceLocation);
    }
}
