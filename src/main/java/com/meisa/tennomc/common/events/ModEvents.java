package com.meisa.tennomc.common.events;

import com.meisa.tennomc.common.lib.Blueprint;
import com.meisa.tennomc.common.items.Blueprints;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    @SubscribeEvent
    public void onPlayerUseItem(LivingEntityUseItemEvent.Start event) {
        PlayerEntity player = (PlayerEntity) event.getEntityLiving();

        Item item = event.getItem().getItem();
        if (item == Blueprints.SKANA_BLUEPRINT.get()) {
            player.getUseItem().shrink(1);
        }
    }

    @SubscribeEvent
    public void onPlayerOpenContainer(PlayerContainerEvent.Open event) {

        PlayerEntity player = event.getPlayer();


        String msg = "You opened a container " + player.getMainHandItem().getItem() + " " + (player.getMainHandItem().getItem() instanceof Blueprint);
        player.sendMessage(new StringTextComponent(msg), player.getUUID());
    }
}
