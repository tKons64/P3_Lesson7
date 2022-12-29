package me.tretyakovv.p3_lesson5.services.impl;

import me.tretyakovv.p3_lesson5.model.Ingredient;
import me.tretyakovv.p3_lesson5.model.Recipe;
import me.tretyakovv.p3_lesson5.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class RecipeServiceImpl implements RecipeService {

    private long lasdId = 0L;

    static HashMap<Long, Recipe> listRecipe = new HashMap<>();

    @Override
    public long addRecipe(Recipe recipe) {
        if (recipe.getIngredients() == null) {
            recipe.setIngredients(new HashMap<Long, Ingredient>());
        }
        listRecipe.put(lasdId, recipe);
        return lasdId++;
    }

    @Override
    public Recipe getRecipe(long id) {
        return listRecipe.get(id);
    }

    @Override
    public Collection<Recipe> getAllRecipe() {
        return listRecipe.values();
    }

    @Override
    public boolean updateRecipe(long id, Recipe recipe) {
        if (listRecipe.containsKey(id)) {
            listRecipe.put(id, recipe);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRecipe(long id) {
        if (listRecipe.containsKey(id)) {
            listRecipe.remove(id);
            return true;
        }
        return false;
    }


}
