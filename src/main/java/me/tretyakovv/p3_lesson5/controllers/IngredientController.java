package me.tretyakovv.p3_lesson5.controllers;

import me.tretyakovv.p3_lesson5.model.Ingredient;
import me.tretyakovv.p3_lesson5.model.Recipe;
import me.tretyakovv.p3_lesson5.services.IngredientService;
import me.tretyakovv.p3_lesson5.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService ingredientService;
    private RecipeService recipeService;

    public IngredientController(IngredientService ingredientService, RecipeService recipeService) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Long> addIngredient(@RequestParam long idRecipe, @RequestBody Ingredient ingredient) {
        Recipe recipe = recipeService.getRecipe(idRecipe);
        if (recipe == null){
            return ResponseEntity.notFound().build();
        }
        long id = ingredientService.addIngredient(recipe, ingredient);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable long id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIngredient() {
        //List<Ingredient> ingredientList = (List<Ingredient>) ingredientService.getAllIngredient();
        return ResponseEntity.ok(ingredientService.getAllIngredient());
    }

    @PutMapping()
    public ResponseEntity<Boolean> updateIngredient(@RequestParam long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.updateIngredient(id, ingredient));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteIngredient(@RequestParam long id) {
       return ResponseEntity.ok(ingredientService.deleteIngredient(id));
    }

    @GetMapping("/page")
    public ResponseEntity<?> getAllIngredientByPage(@RequestParam int numberPage) {
        return ResponseEntity.ok(ingredientService.getAllIngredientByPage(numberPage));
    }
}
