package themcbros.puddingmod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import themcbros.puddingmod.datagen.PuddingGenerators;
import themcbros.puddingmod.init.ModItems;
import themcbros.puddingmod.proxy.ClientProxy;
import themcbros.puddingmod.proxy.CommonProxy;
import themcbros.puddingmod.proxy.ServerProxy;

@Mod(PuddingMod.MOD_ID)
public class PuddingMod {
	public static final String MOD_ID = "puddingmod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.PUDDING.get());
		}
	};

	public static PuddingMod instance;
	public static CommonProxy proxy;

	public PuddingMod() {
		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().register(new PuddingGenerators());

		proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	}

	public static ResourceLocation rl(String pathIn) {
		return new ResourceLocation(MOD_ID, pathIn);
	}
}
