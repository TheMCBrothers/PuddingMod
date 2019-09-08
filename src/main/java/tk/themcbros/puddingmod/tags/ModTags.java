package tk.themcbros.puddingmod.tags;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import tk.themcbros.puddingmod.PuddingMod;

public class ModTags {
	
	public static class Fluids {
		public static final ResourceLocation PUDDING = new ResourceLocation(PuddingMod.MOD_ID, "pudding");
	}

	public static Tag<Fluid> getFluidTag(ResourceLocation name) {
		return FluidTags.getCollection().getOrCreate(name);
	}
	
}
