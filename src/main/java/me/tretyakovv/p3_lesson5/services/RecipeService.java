package me.tretyakovv.p3_lesson5.services;

import me.tretyakovv.p3_lesson5.model.Recipe;

public interface RecipeService {

    void add(Recipe recipe);

    Recipe get(int id);
}
