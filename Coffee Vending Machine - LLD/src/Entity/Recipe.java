package Entity;

import java.util.Map;

public class Recipe {

    private Map<Ingredient, Integer> ingredientQuantity;

    public Recipe(Map<Ingredient, Integer> ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public Map<Ingredient, Integer> getIngredientQuantity() {
        return ingredientQuantity;
    }
}
