package themcbros.puddingmod.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import themcbros.puddingmod.PuddingMod;

public class ServerProxy extends CommonProxy {

	public ServerProxy() {
		super();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
	}
	
	private void serverSetup(FMLDedicatedServerSetupEvent event) {
		PuddingMod.LOGGER.debug("ServerProxy serverSetup method");
	}
	
}