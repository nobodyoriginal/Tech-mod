package net.ND1712.techmod;

import net.ND1712.techmod.registeration.ModBlocks;
import net.ND1712.techmod.registeration.ModFluids;
import net.ND1712.techmod.registeration.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("technology_mod")
public class technology_mod {
	
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "technology_mod";

    public technology_mod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModFluids.FLUIDS.register(bus);
        
        MinecraftForge.EVENT_BUS.register(this);
    
    }
    private void setup(final FMLCommonSetupEvent event) {
    }	
   
}
