package com.mmodding.library.datagen.api.recipe;

import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Consumer;
import java.util.function.Supplier;

@ApiStatus.NonExtendable
public interface RecipeHelper {

	/**
	 * Creates a shaped recipe for the current item
	 * @param category the recipe category
	 * @param consumer the recipe options
	 */
	void shaped(RecipeCategory category, Consumer<ShapedRecipe> consumer);

	/**
	 * Creates a shaped recipe for the current item.
	 * @param count the recipe output count
	 * @param category the recipe category
	 * @param consumer the recipe options
	 */
	void shaped(int count, RecipeCategory category, Consumer<ShapedRecipe> consumer);

	/**
	 * Creates a shapeless recipe for the current item.
	 * @param category the recipe category
	 * @param consumer the recipe options
	 */
	void shapeless(RecipeCategory category, Consumer<ShapelessRecipe> consumer);

	/**
	 * Creates a shapeless recipe for the current item.
	 * @param count the recipe output count
	 * @param category the recipe category
	 * @param consumer the recipe options
	 */
	void shapeless(int count, RecipeCategory category, Consumer<ShapelessRecipe> consumer);

	void smelting(ItemConvertible item, RecipeCategory category, int experience, int time);

	void smelting(Ingredient ingredient, RecipeCategory category, int experience, int time);

	void blasting(ItemConvertible item, RecipeCategory category, int experience, int time);

	void blasting(Ingredient ingredient, RecipeCategory category, int experience, int time);

	void smoking(ItemConvertible item, RecipeCategory category, int experience, int time);

	void smoking(Ingredient ingredient, RecipeCategory category, int experience, int time);

	void factory(Supplier<? extends CraftingRecipeJsonBuilder> factory);

	@ApiStatus.NonExtendable
	interface ShapedRecipe {

		default void key(char key, ItemConvertible item) {
			this.key(key, Ingredient.ofItems(item));
		}

		void key(char key, Ingredient ingredient);

		void pattern(String firstLine, String secondLine, String thirdLine);

		void pattern(String firstLine, String secondLine);
	}

	@ApiStatus.NonExtendable
	interface ShapelessRecipe {

		void with(ItemConvertible... items);

		void with(Ingredient... ingredients);
	}

	@ApiStatus.NonExtendable
	interface SmeltingRecipe {

		default void input(ItemConvertible item) {
			this.input(Ingredient.ofItems(item));
		}

		void input(Ingredient ingredient);

		void time(int time);

		default void output(ItemConvertible item) {
			this.input(Ingredient.ofItems(item));
		}

		void output(Ingredient ingredient);

		void experience(int experience);
	}
}
