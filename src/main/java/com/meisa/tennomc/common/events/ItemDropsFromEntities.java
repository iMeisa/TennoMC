package com.meisa.tennomc.common.events;

import com.meisa.tennomc.common.items.Resources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.Random;

public class ItemDropsFromEntities {

    private static int getDropCount(int minDropCount, int maxDropCount) {
        final int dropModifier = maxDropCount - minDropCount + 1;
        return new Random().nextInt(dropModifier) + minDropCount;
    }

    public static void dropResources(LivingDropsEvent event, Item item, int minDropCount, int maxDropCount, float dropChance) {

        final int randRange = (int) (100 / (dropChance * 100));
        boolean dropItem = new Random().nextInt(randRange) == 0;

        if (!dropItem) { return; }

        final int dropCount = getDropCount(minDropCount, maxDropCount);
        LivingEntity entity = event.getEntityLiving();

        World world = entity.level;
        Collection<ItemEntity> drops = event.getDrops();

        for (int i = 0; i < dropCount; i++) {
            drops.add(new ItemEntity(world, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(item)));
        }
    }

    // Mob drops
    @SubscribeEvent
    public void onEntityDeath(LivingDropsEvent event) {
        LivingEntity source = event.getEntityLiving();

        if (source instanceof SkeletonEntity) { dropResources(event, Resources.ALLOY_PLATES.get(), 3, 6, 0.8f); }
        if (source instanceof CreeperEntity) { dropResources(event, Resources.NEURODE.get(), 1, 1, 0.05f); }
        if (source instanceof SpiderEntity) { dropResources(event, Resources.PLASTIDS.get(), 2, 3, 0.8f); }
    }
}
