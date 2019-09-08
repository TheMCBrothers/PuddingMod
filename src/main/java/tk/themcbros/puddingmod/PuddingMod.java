package tk.themcbros.puddingmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import tk.themcbros.puddingmod.init.ModBlocks;
import tk.themcbros.puddingmod.init.ModItems;

public class PuddingMod implements ModInitializer {
	
	public static final String MOD_ID = "puddingmod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "puddingmod")).icon(() -> new ItemStack(ModItems.PUDDING)).build();
	
	@Override
	public void onInitialize() {
		LOGGER.info("Initalizing {} ...", MOD_ID);
		new ModBlocks();
		new ModItems();
	}
	
}
