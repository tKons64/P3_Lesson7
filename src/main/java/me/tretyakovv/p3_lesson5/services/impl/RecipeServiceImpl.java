package me.tretyakovv.p3_lesson5.services.impl;

import me.tretyakovv.p3_lesson5.model.Recipe;
import me.tretyakovv.p3_lesson5.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class RecipeServiceImpl implements RecipeService {

    private int id = 0;

    private HashMap<Integer, Recipe> listRecipe = new HashMap<Integer, Recipe>();

    @Override
    public void add(Recipe recipe) {
        listRecipe.put(this.id++, recipe);
    }

    @Override
    public Recipe get(int id) {
        return listRecipe.get(id);
    }
}
