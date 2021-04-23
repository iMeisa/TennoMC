package com.meisa.tennomc.common.util;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class InventoryStuff {
    public static int countItemInInv(PlayerInventory inventory, Item item) {
        int count = 0;

        List<ItemStack> items = inventory.items;

        for (ItemStack itemStack : items) {
            if (itemStack.getItem() != item) {
                continue;
            }

            count += itemStack.getCount();
        }

        return count;
    }

    public static void removeItems(PlayerInventory inventory, Item item, int count) {
        ItemStack itemStack = new ItemStack(item);

        while (count > 0) {
            final int removeCount = Math.min(count, 64);

            final int nextSlot = inventory.findSlotMatchingItem(itemStack);
            if (nextSlot < 0) { break; }

            final int slotItemCount = inventory.items.get(nextSlot).getCount();
            final int removedItemCount = Math.min(removeCount, slotItemCount);

            inventory.removeItem(nextSlot, removeCount);

            count -= removedItemCount;
        }
    }
}
