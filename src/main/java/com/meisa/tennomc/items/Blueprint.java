package com.meisa.tennomc.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class Blueprint extends Item {

    public List<Resource> resources;
    public ResourceLocation outputItem;

    public Blueprint(Properties properties, List<Resource> resources, ResourceLocation outputItem) {
        super(properties);
        this.resources = resources;
        this.outputItem = outputItem;
    }


    public static class Resource {
        public final ResourceLocation resourceLocation;
        public final int amount;

        public Resource(ResourceLocation resourceLocation, int amount) {
            this.resourceLocation = resourceLocation;
            this.amount = amount;
        }
    }
}
