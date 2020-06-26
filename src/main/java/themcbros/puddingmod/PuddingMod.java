package tk.themcbros.puddingmod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import tk.themcbros.puddingmod.init.ModItems;
import tk.themcbros.puddingmod.proxy.ClientProxy;
import tk.themcbros.puddingmod.proxy.CommonProxy;
import tk.themcbros.puddingmod.proxy.ServerProxy;

@Mod(PuddingMod.MOD_ID)
public class PuddingMod {
	public static final String MOD_ID = "puddingmod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.PUDDING);
		}
	};

	public static PuddingMod instance;
	public static CommonProxy proxy;

	public PuddingMod() {
		instance = this;
		proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	}

	public static ResourceLocation location(String pathIn) {
		return new ResourceLocation(MOD_ID, pathIn);
	}
}
