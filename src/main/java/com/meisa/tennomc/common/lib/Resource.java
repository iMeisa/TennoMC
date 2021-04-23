package com.meisa.tennomc.common.lib;

import net.minecraft.util.ResourceLocation;

public class Resource {
    public final ResourceLocation resourceLocation;
    public final int amount;

    public Resource(ResourceLocation resourceLocation, int amount) {
        this.resourceLocation = resourceLocation;
        this.amount = amount;
    }
}
