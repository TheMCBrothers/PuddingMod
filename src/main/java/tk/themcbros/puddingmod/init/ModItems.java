package tk.themcbros.puddingmod.init;

import com.google.common.collect.Lists;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tk.themcbros.puddingmod.PuddingMod;

import java.util.List;

public class ModItems {

	private static final List<Item> ITEMS = Lists.newArrayList();

	public static final BlockItem PUDDING_BLOCK = register("pudding_block", new BlockItem(ModBlocks.PUDDING_BLOCK, new Item.Properties().group(PuddingMod.ITEM_GROUP)));
	
	public static final Item RAW_PUDDING = register("raw_pudding", new Item(new Item.Properties().food(FoodList.RAW_PUDDING).group(PuddingMod.ITEM_GROUP)));
	public static final SoupItem PUDDING = register("pudding", new SoupItem(new Item.Properties().group(PuddingMod.ITEM_GROUP).food(FoodList.PUDDING).maxStackSize(1)));
	public static final BucketItem PUDDING_BUCKET = register("pudding_bucket", new BucketItem(() -> ModFluids.PUDDING, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(PuddingMod.ITEM_GROUP)));
	
	private static <T extends Item> T register(String registryName, T item) {
		item.setRegistryName(PuddingMod.location(registryName));
		ITEMS.add(item);
		return item;
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PuddingMod.MOD_ID)
	public static class Registration {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			ITEMS.forEach(event.getRegistry()::register);
			PuddingMod.LOGGER.debug("Registered items");
		}
	}
	
}
