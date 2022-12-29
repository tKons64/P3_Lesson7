package me.tretyakovv.p3_lesson5.services;

import me.tretyakovv.p3_lesson5.model.Recipe;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface RecipeService {

    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    Collection<Recipe> getAllRecipe();

    boolean updateRecipe(long id, Recipe recipe);

    boolean deleteRecipe(long id);

    Recipe findRecipeByIngrediantId(long idIngrediant);

    List<Recipe> findRecipesByIngrediants(long[] arrIngredientsId);
}
