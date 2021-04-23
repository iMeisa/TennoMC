package com.meisa.tennomc.common.items;

import com.meisa.tennomc.TennoMC;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Swords {

    private static final DeferredRegister<Item> SWORDS = DeferredRegister.create(ForgeRegistries.ITEMS, TennoMC.MOD_ID);

    public static final RegistryObject<Item> SKANA =
            SWORDS.register("skana",
                    () -> new SwordItem(SwordTier.ONE_HANDED, 2, 1,
                            new Item.Properties().tab(TennoMC.TAB_TENNO)));


    public static void register() { SWORDS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

    public enum SwordTier implements IItemTier {
        ONE_HANDED(1000, 1, 1, 1, 1, Ingredient.of(Resources.MORPHICS.get()));

        private final int maxUses;
        private final int speed;
        private final int attackBonus;
        private final int harvestLevel;
        private final int enchantability;
        private final Ingredient repairIngredient;

        SwordTier(int maxUses, int speed, int attackBonus, int harvestLevel, int enchantability, Ingredient repairIngredient) {
            this.maxUses = maxUses;
            this.speed = speed;
            this.attackBonus = attackBonus;
            this.harvestLevel = harvestLevel;
            this.enchantability = enchantability;
            this.repairIngredient = repairIngredient;
        }


        @Override
        public int getUses() {
            return maxUses;
        }

        @Override
        public float getSpeed() {
            return speed;
        }

        @Override
        public float getAttackDamageBonus() {
            return attackBonus;
        }

        @Override
        public int getLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairIngredient;
        }
    }
}
