package tk.themcbros.puddingmod.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tk.themcbros.puddingmod.PuddingMod;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {

	public ClientProxy() {
		super();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
	}

	private void clientSetup(FMLClientSetupEvent event) {
		PuddingMod.LOGGER.debug("ClientProxy clientSetup method");
	}
}