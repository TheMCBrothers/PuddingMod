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
        ShapedRecipeBuilder.shapedRecipe(ModItems.PUDDING_BLOCK.get()).patternLine("###").patternLine("###").patternLine("###").key('#', ModItems.RAW_PUDDING.get()).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.RAW_PUDDING.get(), 9).addIngredient(ModItems.PUDDING_BLOCK.get()).addCriterion("has_pudding_block", hasItem(ModItems.PUDDING_BLOCK.get())).build(consumer, "");
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.PUDDING_BUCKET.get()).addIngredient(Items.BUCKET).addIngredient(ModItems.RAW_PUDDING.get(), 4).addCriterion("has_pudding", hasItem(ModItems.RAW_PUDDING.get())).addCriterion("has_bucket", hasItem(Items.BUCKET)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.PUDDING.get()).addIngredient(Items.BOWL).addIngredient(ModItems.RAW_PUDDING.get()).addCriterion("has_bowl", hasItem(Items.BOWL)).addCriterion("has_raw_pudding", hasItem(ModItems.RAW_PUDDING.get())).build(consumer);
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.RAW_PUDDING.get()), ModItems.RAW_PUDDING.get(), 0.1F, 600, IRecipeSerializer.CAMPFIRE_COOKING).build(consumer, "raw_pudding_cooking");
        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(ModItems.RAW_PUDDING.get()), ModItems.RAW_PUDDING.get(), 0.1F, 200, IRecipeSerializer.SMOKING).build(consumer, "raw_pudding_cooking");
    }

    @Override
    public String getName() {
        return "Recipes for Pudding Mod";
    }
}
