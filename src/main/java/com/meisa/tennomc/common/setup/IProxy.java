package com.meisa.tennomc.common.setup;

import net.minecraft.world.World;

public interface IProxy {

    void init();

    World getClientWorld();
}
