package me.tretyakovv.p3_lesson5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class Recipe {

    private String title;

    private int preparationTime;

    private HashMap<Long, Ingredient> ingredients;

    private List<String> steps;

}
