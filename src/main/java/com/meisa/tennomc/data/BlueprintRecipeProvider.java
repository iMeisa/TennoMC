package com.meisa.tennomc.data;

import com.meisa.tennomc.common.items.Blueprints;
import com.meisa.tennomc.common.items.Resources;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class BlueprintRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public BlueprintRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> finishedRecipe) {

        ShapelessRecipeBuilder.shapeless(Blueprints.SKANA_BLUEPRINT.get())
                .requires(Resources.SALVAGE.get())
                .requires(Resources.PLASTIDS.get())
                .requires(Resources.ALLOY_PLATES.get())
                .requires(Blueprints.BLUEPRINT.get())
                .unlockedBy("morphics", has(Resources.SALVAGE.get()))
                .save(finishedRecipe);

        ShapelessRecipeBuilder.shapeless(Blueprints.ETHER_SWORD_BLUEPRINT.get())
                .requires(Resources.RUBEDO.get())
                .requires(Resources.FERRITE.get())
                .requires(Resources.ALLOY_PLATES.get())
                .requires(Blueprints.BLUEPRINT.get())
                .unlockedBy("rubedo", has(Resources.RUBEDO.get()))
                .save(finishedRecipe);

        ShapelessRecipeBuilder.shapeless(Blueprints.BLUEPRINT.get())
                .requires(Items.PAPER)
                .requires(Items.BLUE_DYE)
                .unlockedBy("paper", has(Items.PAPER))
                .save(finishedRecipe);

    }

}
