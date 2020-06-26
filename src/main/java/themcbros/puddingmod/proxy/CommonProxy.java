package tk.themcbros.puddingmod.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tk.themcbros.puddingmod.PuddingMod;

public class CommonProxy {

	public CommonProxy() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postInit);
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
