package Entity;

import java.util.HashMap;
import java.util.Map;
import Enum.CoffeeType;

public class Menu {
    // Map is an interface, while HashMap is a concrete class that implements the Map interface.
    private Map<CoffeeType, Recipe> items = new HashMap<>();

    public void addCoffeeInMenu(CoffeeType type, Recipe recipe){
        items.put(type, recipe);
    }

    public void displayMenu(){
        System.out.println(("Menu:"));
        for(CoffeeType type: items.keySet()){
            System.out.println((type));
        }
    }

    public Recipe getRecipe(CoffeeType coffeeType){
        return items.get(coffeeType);
    }

}
