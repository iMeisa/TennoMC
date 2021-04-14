package com.meisa.tennomc.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.Random;

public class ItemDropsFromEntities {

    // Neurodes drop from creepers
    @SubscribeEvent
    public void neurodeDrop(LivingDropsEvent event) {

        // 5% chance to drop
        boolean dropItem = new Random().nextInt(20)==0;

        if (!dropItem) {
            return;
        }

        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof CreeperEntity) {
            World world = entity.level;
            Collection<ItemEntity> drops = event.getDrops();

            drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(),
                    new ItemStack(Resources.NEURODE.get())));

        }
    }
}
