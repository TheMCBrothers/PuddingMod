package tk.themcbros.puddingmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import tk.themcbros.puddingmod.PuddingMod;

@Mod.EventBusSubscriber(modid = PuddingMod.MOD_ID)
public class PuddingGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new PuddingRecipeProvider(generator));
    }

}
