package Entity;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Ingredient, Integer> stock = new HashMap<>();

    public void addStock(Ingredient ingredient, int quantity){
        stock.put(ingredient, stock.getOrDefault(ingredient, 0) + quantity);
    }

    public boolean hasSufficientIngredients(Recipe recipe){
        // Map.Entry<K, V> is used when iterating over a Map's key-value pairs efficiently.
        /*
        recipe.getIngredients().entrySet() returns a Set of key-value pairs where:
        items.getKey() → The Ingredient (e.g., Coffee, Milk, Sugar).
        items.getValue() → The required quantity of that ingredient.
         */
        for(Map.Entry<Ingredient, Integer> items: recipe.getIngredientQuantity().entrySet()){
            if(stock.getOrDefault(items.getKey(), 0) < items.getValue()){
                return false;
            }
        }
        return true;
    }

    public void useIngredients(Recipe recipe){
        for(Map.Entry<Ingredient, Integer> item: recipe.getIngredientQuantity().entrySet()){
            stock.put(item.getKey(), stock.get(item.getKey()) -  item.getValue());
        }
    }

    public int getAvailableQuantity(Ingredient ingredient){
        return stock.getOrDefault(ingredient, 0);
    }

}
