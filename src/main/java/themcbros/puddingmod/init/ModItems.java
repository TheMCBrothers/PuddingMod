package themcbros.puddingmod.init;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import themcbros.puddingmod.PuddingMod;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PuddingMod.MOD_ID);

	public static final RegistryObject<BlockItem> PUDDING_BLOCK = ITEMS.register("pudding_block",
			() -> new BlockItem(ModBlocks.PUDDING_BLOCK.get(), new Item.Properties().group(PuddingMod.ITEM_GROUP)));
	
	public static final RegistryObject<Item> RAW_PUDDING = ITEMS.register("raw_pudding",
			() -> new Item(new Item.Properties().food(FoodList.RAW_PUDDING).group(PuddingMod.ITEM_GROUP)));
	public static final RegistryObject<SoupItem> PUDDING = ITEMS.register("pudding",
			() -> new SoupItem(new Item.Properties().group(PuddingMod.ITEM_GROUP).food(FoodList.PUDDING).maxStackSize(1)));
	public static final RegistryObject<BucketItem> PUDDING_BUCKET = ITEMS.register("pudding_bucket",
			() -> new BucketItem(() -> ModFluids.PUDDING, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(PuddingMod.ITEM_GROUP)));
	
}
