package tk.themcbros.puddingmod.init;

import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.fluids.PuddingFluid;

public class ModFluids {

	public static final BaseFluid PUDDING;
	public static final BaseFluid FLOWING_PUDDING;
	
	static {
		PUDDING = (BaseFluid) registerFluid("pudding", new PuddingFluid.Still());
		FLOWING_PUDDING = (BaseFluid) registerFluid("flowing_pudding", new PuddingFluid.Flowing());
	}
	
	private static Fluid registerFluid(String regName, Fluid fluid) {
		return (Fluid) Registry.register(Registry.FLUID, new Identifier(PuddingMod.MOD_ID, regName), fluid);
	}
	
}
