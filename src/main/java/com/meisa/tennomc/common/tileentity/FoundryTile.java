package com.meisa.tennomc.common.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class FoundryTile extends TileEntity {

    public FoundryTile(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public FoundryTile() {
        this(ModTileEntites.FOUNDRY_TILE_ENTITY.get());
    }
}
