package themcbros.puddingmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import themcbros.puddingmod.PuddingMod;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PuddingMod.MOD_ID);
	
	public static final RegistryObject<SlimeBlock> PUDDING_BLOCK = BLOCKS.register("pudding_block",
			() -> new SlimeBlock(Block.Properties.create(Material.CLAY, MaterialColor.YELLOW).sound(SoundType.SLIME).hardnessAndResistance(0.2f)));
	public static final RegistryObject<FlowingFluidBlock> PUDDING = BLOCKS.register("pudding",
			() -> new FlowingFluidBlock(() -> ModFluids.PUDDING, Block.Properties.create(Material.WATER).hardnessAndResistance(1000f)));

}
