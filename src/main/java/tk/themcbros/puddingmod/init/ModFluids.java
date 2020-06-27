package tk.themcbros.puddingmod.init;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.themcbros.puddingmod.PuddingFluid;
import tk.themcbros.puddingmod.PuddingMod;

public class ModFluids {

    public static final FlowableFluid PUDDING;
    public static final FlowableFluid FLOWING_PUDDING;

    static {
        PUDDING = register("pudding", new PuddingFluid.Still());
        FLOWING_PUDDING = register("flowing_pudding", new PuddingFluid.Flowing());
    }

    private static <T extends Fluid> T register(String registryName, T fluid) {
        return Registry.register(Registry.FLUID, new Identifier(PuddingMod.MOD_ID, registryName), fluid);
    }

}
