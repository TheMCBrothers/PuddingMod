package tk.themcbros.puddingmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.block.PuddingFluidBlock;

public class ModBlocks {

	public static final SlimeBlock PUDDING_BLOCK;
	public static final FluidBlock PUDDING;

	static {
		PUDDING_BLOCK = register("pudding_block", new SlimeBlock(Block.Settings.copy(Blocks.SLIME_BLOCK)));
		PUDDING = register("pudding", new PuddingFluidBlock(ModFluids.PUDDING, Block.Settings.copy(Blocks.WATER)));
	}
	
	private static <T extends Block> T register(String regName, T block) {
		return Registry.register(Registry.BLOCK, new Identifier(PuddingMod.MOD_ID, regName), block);
	}
	
}
