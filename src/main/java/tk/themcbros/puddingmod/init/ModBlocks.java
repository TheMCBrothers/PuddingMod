package tk.themcbros.puddingmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlimeBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.fluids.ModFluidBlock;

public class ModBlocks {

	public static final Block PUDDING_BLOCK;
	public static final Block PUDDING;
	
	static {
		PUDDING_BLOCK = register("pudding_block", new SlimeBlock(Block.Settings.copy(Blocks.SLIME_BLOCK)));
		PUDDING = register("pudding", new ModFluidBlock(ModFluids.PUDDING, Block.Settings.copy(Blocks.WATER)));
	}
	
	private static Block register(String regName, Block block) {
		return (Block) Registry.register(Registry.BLOCK, new Identifier(PuddingMod.MOD_ID, regName), block);
	}
	
}
