package com.meisa.tennomc.data;

import com.meisa.tennomc.TennoMC;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemResourceProvider extends ItemModelProvider {
    public ItemResourceProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TennoMC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        withExistingParent("argon_deposit", modLoc("block/argon_deposit"));
        withExistingParent("ferrite_deposit", modLoc("block/ferrite_deposit"));
        withExistingParent("rubedo_deposit", modLoc("block/rubedo_deposit"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "blueprint");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
