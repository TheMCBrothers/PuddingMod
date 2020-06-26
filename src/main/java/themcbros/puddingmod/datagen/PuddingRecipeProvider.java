package themcbros.puddingmod.datagen;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import themcbros.puddingmod.init.ModItems;

import java.util.function.Consumer;

public class PuddingRecipeProvider extends RecipeProvider {

    public PuddingRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(ModItems.PUDDING_BLOCK).patternLine("###").patternLine("###").patternLine("###").key('#', ModItems.RAW_PUDDING).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.RAW_PUDDING, 9).addIngredient(ModItems.PUDDING_BLOCK).addCriterion("has_pudding_block", this.hasItem(ModItems.PUDDING_BLOCK)).build(consumer, "");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.PUDDING_BUCKET).addIngredient(Items.BUCKET).addIngredient(ModItems.RAW_PUDDING, 4).addCriterion("has_pudding", this.hasItem(ModItems.RAW_PUDDING)).addCriterion("has_bucket", this.hasItem(Items.BUCKET)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.PUDDING).addIngredient(Items.BOWL).addIngredient(ModItems.RAW_PUDDING).addCriterion("has_bowl", this.hasItem(Items.BOWL)).addCriterion("has_raw_pudding", this.hasItem(ModItems.RAW_PUDDING)).build(consumer);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.RAW_PUDDING), ModItems.RAW_PUDDING, 0.1F, 600, IRecipeSerializer.CAMPFIRE_COOKING).build(consumer, "raw_pudding_cooking");
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.RAW_PUDDING), ModItems.RAW_PUDDING, 0.1F, 200, IRecipeSerializer.SMOKING).build(consumer, "raw_pudding_cooking");
    }

    @Override
    public String getName() {
        return "Recipes for Pudding Mod";
    }
}
