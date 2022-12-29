package me.tretyakovv.p3_lesson5.controllers;

import me.tretyakovv.p3_lesson5.model.Ingredient;
import me.tretyakovv.p3_lesson5.model.Recipe;
import me.tretyakovv.p3_lesson5.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe) {
        long id = recipeService.addRecipe(recipe) ;
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRecipe() {
        return ResponseEntity.ok(recipeService.getAllRecipe());
    }

    @PutMapping()
    public ResponseEntity<Boolean> updateRecipe(@RequestParam long id, @RequestBody Recipe recipe) {
        if (recipeService.updateRecipe(id, recipe)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteIngredient(@RequestParam long id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/find/byIngredient")
    public ResponseEntity<Recipe> findRecipeByIngrediantId(@RequestParam long idIngrediant) {
        Recipe recipe = recipeService.findRecipeByIngrediantId(idIngrediant);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/find/byIngredients")
    public ResponseEntity<?> findRecipesByIngrediantsId(@RequestParam long[] idIngrediants) {
        return ResponseEntity.ok(recipeService.findRecipesByIngrediants(idIngrediants));
    }

}
