package themcbros.puddingmod.init;

import com.google.common.collect.Lists;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import themcbros.puddingmod.PuddingMod;

import java.util.List;

@ObjectHolder(PuddingMod.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PuddingMod.MOD_ID)
public class ModFluids {

	private static final List<Fluid> FLUIDS = Lists.newArrayList();
	
	public static final FlowingFluid FLOWING_PUDDING;
	public static final FlowingFluid PUDDING;

	static {
		ForgeFlowingFluid.Properties puddingProperties = new ForgeFlowingFluid.Properties(() -> ModFluids.PUDDING, () -> ModFluids.FLOWING_PUDDING,
				FluidAttributes.builder(PuddingMod.rl("block/pudding_still"), PuddingMod.rl("block/pudding_flow"))
						.density(1200).gaseous().luminosity(15).translationKey("block.puddingmod.pudding")).block(ModBlocks.PUDDING).bucket(ModItems.PUDDING_BUCKET)
				.levelDecreasePerBlock(2).explosionResistance(1000f);
		FLOWING_PUDDING = register("flowing_pudding", new ForgeFlowingFluid.Flowing(puddingProperties));
		PUDDING = register("pudding", new ForgeFlowingFluid.Source(puddingProperties));
	}
	
	private static <T extends Fluid> T register(String registryName, T fluid) {
		fluid.setRegistryName(PuddingMod.rl(registryName));
		FLUIDS.add(fluid);
		return fluid;
	}

	public static void init() {}

	@SubscribeEvent
	public static void registerFluids(final RegistryEvent.Register<Fluid> event) {
		FLUIDS.forEach(event.getRegistry()::register);
		PuddingMod.LOGGER.debug("Registered fluids");
	}
	
}
