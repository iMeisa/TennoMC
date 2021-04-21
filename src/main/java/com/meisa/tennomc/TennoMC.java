package com.meisa.tennomc;

import com.meisa.tennomc.blocks.Deposits;
import com.meisa.tennomc.items.ItemDropsFromEntities;
import com.meisa.tennomc.items.Resources;
import com.meisa.tennomc.setup.ClientProxy;
import com.meisa.tennomc.setup.IProxy;
import com.meisa.tennomc.setup.ServerProxy;
import com.meisa.tennomc.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TennoMC.MOD_ID)
public class TennoMC {

    public static final String MOD_ID = "tennomc";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public static final ItemGroup TAB_TENNO = new ItemGroup("tabTenno") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Resources.NEURODE.get());
        }
    };

    public static IProxy proxy;


    public TennoMC() {

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { proxy.init(); }

    private void registerModAdditions() {

        // Inits additions
        Registration.init();

        // Inits in game items
        Resources.register();
        Deposits.register();

        // Inits events
        MinecraftForge.EVENT_BUS.register(new ItemDropsFromEntities());
    }
}
