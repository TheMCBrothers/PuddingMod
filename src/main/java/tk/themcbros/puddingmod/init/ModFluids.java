package tk.themcbros.puddingmod.init;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tk.themcbros.puddingmod.PuddingMod;
import tk.themcbros.puddingmod.fluids.PuddingFluid;

public class ModFluids {

	private static final List<Fluid> FLUIDS = Lists.newArrayList();
	
	public static final FlowingFluid FLOWING_PUDDING = (FlowingFluid) register("flowing_pudding", new PuddingFluid.Flowing());
	public static final FlowingFluid PUDDING = (FlowingFluid) register("pudding", new PuddingFluid.Source());
	
	private static Fluid register(String registryName, Fluid fluid) {
		fluid.setRegistryName(new ResourceLocation(PuddingMod.MOD_ID, registryName));
		FLUIDS.add(fluid);
		return fluid;
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PuddingMod.MOD_ID)
	public static class Registration {
		@SubscribeEvent
		public static void registerFluids(final RegistryEvent.Register<Fluid> event) {
			FLUIDS.forEach(fluid -> {
				event.getRegistry().register(fluid);
			});
			PuddingMod.LOGGER.debug("Registered fluids");
		}
	}
	
}
