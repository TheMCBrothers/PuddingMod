package themcbros.puddingmod.init;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import themcbros.puddingmod.PuddingMod;

import java.util.List;

@ObjectHolder(PuddingMod.MOD_ID)
@Mod.EventBusSubscriber(modid = PuddingMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

	private static final List<Block> BLOCKS = Lists.newArrayList();
	
	public static final SlimeBlock PUDDING_BLOCK = register("pudding_block", new SlimeBlock(Block.Properties.create(Material.CLAY, MaterialColor.YELLOW).sound(SoundType.SLIME).hardnessAndResistance(0.2f)));
	public static final FlowingFluidBlock PUDDING = register("pudding", new FlowingFluidBlock(() -> ModFluids.PUDDING, Block.Properties.create(Material.WATER).hardnessAndResistance(1000f)));
	
	private static <T extends Block> T register(String registryName, T block) {
		block.setRegistryName(PuddingMod.location(registryName));
		BLOCKS.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		BLOCKS.forEach(event.getRegistry()::register);
		PuddingMod.LOGGER.debug("Registered blocks");
	}

}
