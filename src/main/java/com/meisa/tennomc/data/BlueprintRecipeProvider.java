package com.meisa.tennomc.data;

import com.meisa.tennomc.common.items.Blueprints;
import com.meisa.tennomc.common.items.Resources;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
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
                .requires(Resources.MORPHICS.get())
                .requires(Blueprints.BLUEPRINT.get())
                .unlockedBy("morphics", has(Resources.MORPHICS.get()))
                .save(finishedRecipe);

    }

}
