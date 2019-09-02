package tk.themcbros.puddingmod.init;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.blocks.PuddingFlowingFluidBlock;

public class ModBlocks {

	public static final Map<Block, BlockItem> BLOCK_ITEMS = Maps.newHashMap();
	private static final List<Block> BLOCKS = Lists.newArrayList();
	
	public static final Block PUDDING_BLOCK = register("pudding_block", new SlimeBlock(Block.Properties.create(Material.CLAY, MaterialColor.YELLOW).sound(SoundType.SLIME).hardnessAndResistance(0.2f)));
	public static final Block PUDDING = registerNoItem("pudding", new PuddingFlowingFluidBlock(ModFluids.PUDDING, Block.Properties.from(Blocks.WATER)));
	
	private static Block register(String registryName, Block block) {
		block.setRegistryName(new ResourceLocation(PuddingMod.MOD_ID, registryName));
		BLOCKS.add(block);
		BlockItem blockItem = (BlockItem) new BlockItem(block, new Item.Properties().group(PuddingMod.ITEM_GROUP)).setRegistryName(block.getRegistryName());
		BLOCK_ITEMS.put(block, blockItem);
		return block;
	}
	
	private static Block registerNoItem(String registryName, Block block) {
		block.setRegistryName(new ResourceLocation(PuddingMod.MOD_ID, registryName));
		BLOCKS.add(block);
		return block;
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PuddingMod.MOD_ID)
	public static class Registration {
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			BLOCKS.forEach(block -> {
				event.getRegistry().register(block);
			});
			PuddingMod.LOGGER.debug("Registered blocks");
		}

		@SubscribeEvent
		public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
			BLOCK_ITEMS.forEach((block, blockItem) -> {
				event.getRegistry().register(blockItem);
			});
			PuddingMod.LOGGER.debug("Registered block items");
		}
	}
	
}
