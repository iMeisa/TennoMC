package com.meisa.tennomc.items;

import com.meisa.tennomc.util.StringRenamer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
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

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, World world, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Resources:"));
        for (Resource resource : resources) {
            String resourceName = resource.resourceLocation.getPath();
            if (resourceName.contains("_")) {
                resourceName = StringRenamer.snakeToText(resourceName);
            } else {
                resourceName = StringRenamer.capitalize(resourceName);
            }
            
            final String requirement = resource.amount + " " + resourceName;
            tooltip.add(new StringTextComponent(requirement));
        }
    }
}
