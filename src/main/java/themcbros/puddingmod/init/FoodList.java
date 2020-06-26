package tk.themcbros.puddingmod.init;

import net.minecraft.item.Food;

class FoodList {

	static final Food RAW_PUDDING = new Food.Builder().hunger(2).saturation(1f).fastToEat().setAlwaysEdible().build();
	static final Food PUDDING = new Food.Builder().hunger(7).saturation(4f).build();
	
}
