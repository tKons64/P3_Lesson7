package me.tretyakovv.p3_lesson5.services;

import me.tretyakovv.p3_lesson5.model.Ingredient;
import me.tretyakovv.p3_lesson5.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    long addIngredient(Recipe recipe, Ingredient ingredient);

    Ingredient getIngredient(long id);

    List<Ingredient> getAllIngredient();

    boolean updateIngredient(long id, Ingredient igredient);

    boolean deleteIngredient(long idIngredient);

    List<Ingredient> getAllIngredientByPage(int numberPage);
}
