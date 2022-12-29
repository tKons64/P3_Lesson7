package me.tretyakovv.p3_lesson5.services.impl;

import me.tretyakovv.p3_lesson5.model.Ingredient;
import me.tretyakovv.p3_lesson5.model.Recipe;
import me.tretyakovv.p3_lesson5.services.IngredientService;
import me.tretyakovv.p3_lesson5.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private long lasdId = 0L;

    private RecipeService recipeService;

    public IngredientServiceImpl(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public long addIngredient(Recipe recipe, Ingredient ingredient) {
        HashMap<Long, Ingredient> listIngredients = recipe.getIngredients();
        if (listIngredients == null) {
            listIngredients = new HashMap<>();
        }
        listIngredients.put(lasdId, ingredient);
        return lasdId++;
    }

    @Override
    public Ingredient getIngredient(long id) {
        for (Recipe recipe : recipeService.getAllRecipe()) {
            if (recipe.getIngredients().containsKey(id)) {
                return recipe.getIngredients().get(id);
            }
        }
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredient() {
        List<Ingredient> listIngredient = new LinkedList<>();

        for (Recipe recipe : recipeService.getAllRecipe()) {
            listIngredient.addAll(recipe.getIngredients().values());
        }
        return listIngredient;
    }

    @Override
    public boolean updateIngredient(long id, Ingredient igredient) {
        for (Recipe recipe : recipeService.getAllRecipe()) {
            if (recipe.getIngredients().containsKey(id)) {
                recipe.getIngredients().put(id, igredient);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteIngredient(long id) {
        for (Recipe recipe : recipeService.getAllRecipe()) {
            if (recipe.getIngredients().containsKey(id)) {
                recipe.getIngredients().remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Ingredient> getAllIngredientByPage(int numberPage) {
        List<Ingredient> listIngredientLimited = new LinkedList<>();

        int onePage = 2;
        int start = onePage * numberPage - onePage;
        int end = onePage * numberPage;

        int counter = 0;

        for (Ingredient ingredient : getAllIngredient()) {
            if (counter >= start && counter < end) {
                listIngredientLimited.add(ingredient);
            }
            counter++;
        }
        return listIngredientLimited;
    }

}
