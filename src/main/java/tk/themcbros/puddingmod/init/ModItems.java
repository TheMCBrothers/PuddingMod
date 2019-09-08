package tk.themcbros.puddingmod.init;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.items.PuddingBucketItem;

public class ModItems {

	public static final Item PUDDING_BLOCK;
	public static final Item RAW_PUDDING;
	public static final Item PUDDING;
	public static final Item PUDDING_BUCKET;
	
	static {
		PUDDING_BLOCK = registerItem("pudding_block", new BlockItem(ModBlocks.PUDDING_BLOCK, new Item.Settings().group(PuddingMod.ITEM_GROUP)));
		RAW_PUDDING = registerItem("raw_pudding", new Item(new Item.Settings().group(PuddingMod.ITEM_GROUP).food(FoodList.RAW_PUDDING)));
		PUDDING = registerItem("pudding", new MushroomStewItem(new Item.Settings().group(PuddingMod.ITEM_GROUP).food(FoodList.PUDDING).maxCount(1)));
		PUDDING_BUCKET = registerItem("pudding_bucket", new PuddingBucketItem(Fluids.EMPTY, new Item.Settings().group(PuddingMod.ITEM_GROUP).maxCount(1)));
	}
	
	private static Item registerItem(String regName, Item item) {
		return (Item) Registry.register(Registry.ITEM, new Identifier(PuddingMod.MOD_ID, regName), item);
	}
	
}
