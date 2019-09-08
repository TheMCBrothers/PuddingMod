package tk.themcbros.puddingmod.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class PuddingBucketItem extends BucketItem {

	public PuddingBucketItem(Fluid fluid_1, Settings item$Settings_1) {
		super(fluid_1, item$Settings_1);
	}
	
	@Override
	public void appendTooltip(ItemStack itemStack_1, World world_1, List<Text> list_1,
			TooltipContext tooltipContext_1) {
		list_1.add(new net.minecraft.text.LiteralText("This item is useless").formatted(Formatting.GRAY, Formatting.ITALIC));
	}

}
