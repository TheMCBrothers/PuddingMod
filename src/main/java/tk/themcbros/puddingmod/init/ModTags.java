package tk.themcbros.puddingmod.init;

import net.minecraft.fluid.Fluid;
import net.minecraft.tag.GlobalTagAccessor;
import net.minecraft.tag.Tag;

public class ModTags {

    public static class Fluids {

        private static final GlobalTagAccessor<Fluid> ACCESSOR = new GlobalTagAccessor<>();
        public static final Tag.Identified<Fluid> PUDDING = register("pudding");

        private static Tag.Identified<Fluid> register(String id) {
            return ACCESSOR.get(id);
        }

    }

}
