package tk.themcbros.puddingmod.init;

import net.minecraft.item.FoodComponent;

public class FoodList {

	protected static final FoodComponent RAW_PUDDING = new FoodComponent.Builder().hunger(2).saturationModifier(1f).snack().build();
	protected static final FoodComponent PUDDING = new FoodComponent.Builder().hunger(7).saturationModifier(4f).build();
	
}
