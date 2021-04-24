package com.meisa.tennomc.data;

import com.meisa.tennomc.TennoMC;
import com.meisa.tennomc.common.blocks.Deposits;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider (DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, TennoMC.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        simpleBlock(Deposits.ARGON_DEPOSIT.get());
        simpleBlock(Deposits.FERRITE_DEPOSIT.get());
        simpleBlock(Deposits.RUBEDO_DEPOSIT.get());
    }
}
