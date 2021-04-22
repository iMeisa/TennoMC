package com.meisa.tennomc;

import com.meisa.tennomc.blocks.Deposits;
import com.meisa.tennomc.blocks.ModBlocks;
import com.meisa.tennomc.events.ItemDropsFromEntities;
import com.meisa.tennomc.items.Resources;
import com.meisa.tennomc.items.Swords;
import com.meisa.tennomc.setup.ClientProxy;
import com.meisa.tennomc.setup.IProxy;
import com.meisa.tennomc.setup.ServerProxy;
import com.meisa.tennomc.util.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        ModBlocks.register();
        Swords.register();

        // Inits events
        MinecraftForge.EVENT_BUS.register(new ItemDropsFromEntities());
    }
}
