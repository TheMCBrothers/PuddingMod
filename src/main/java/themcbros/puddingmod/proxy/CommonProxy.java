package themcbros.puddingmod.proxy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import themcbros.puddingmod.PuddingMod;
import themcbros.puddingmod.init.ModBlocks;
import themcbros.puddingmod.init.ModFluids;
import themcbros.puddingmod.init.ModItems;

public class CommonProxy {

	public CommonProxy() {

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModFluids.init();
		ModBlocks.BLOCKS.register(bus);
		ModItems.ITEMS.register(bus);

		bus.addListener(this::preInit);
		bus.addListener(this::init);
		bus.addListener(this::postInit);
	}
	
	protected void preInit(FMLCommonSetupEvent event) {
		PuddingMod.LOGGER.debug("CommonProxy preInit method");
	}
	
	protected void init(InterModEnqueueEvent event) {
		PuddingMod.LOGGER.debug("CommonProxy init method");
	}
	
	protected void postInit(InterModProcessEvent event) {
		PuddingMod.LOGGER.debug("CommonProxy postInit method");
	}
	
}
