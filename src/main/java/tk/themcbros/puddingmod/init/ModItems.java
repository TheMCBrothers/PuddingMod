package tk.themcbros.puddingmod.init;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SoupItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tk.themcbros.puddingmod.PuddingMod;

public class ModItems {

	private static final List<Item> ITEMS = Lists.newArrayList();
	
	public static final Item RAW_PUDDING = register("raw_pudding", new Item(new Item.Properties().food(FoodList.RAW_PUDDING).group(PuddingMod.ITEM_GROUP)));
	public static final Item PUDDING = register("pudding", new SoupItem(new Item.Properties().group(PuddingMod.ITEM_GROUP).food(FoodList.PUDDING).maxStackSize(1)));
	public static final Item PUDDING_BUCKET = register("pudding_bucket", new BucketItem(ModFluids.PUDDING, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(PuddingMod.ITEM_GROUP)));
	
	private static Item register(String registryName, Item item) {
		item.setRegistryName(new ResourceLocation(PuddingMod.MOD_ID, registryName));
		ITEMS.add(item);
		return item;
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PuddingMod.MOD_ID)
	public static class Registration {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			ITEMS.forEach(item -> {
				event.getRegistry().register(item);
			});
			PuddingMod.LOGGER.debug("Registered items");
		}
	}
	
}
