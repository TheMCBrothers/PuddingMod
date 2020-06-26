package tk.themcbros.puddingmod.init;

import net.minecraft.fluid.Fluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import tk.themcbros.puddingmod.PuddingMod;

public class ModTags {

    public static class Fluids {

        public static final Tag<Fluid> PUDDING = register("pudding");

        private static Tag<Fluid> register(String string_1) {
            return new FluidTags.CachingTag(new Identifier(PuddingMod.MOD_ID, string_1));
        }

    }

}
