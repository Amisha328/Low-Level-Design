import Entity.Ingredient;
import Entity.Inventory;
import Entity.Menu;
import Entity.Recipe;
import Enum.CoffeeType;
import Strategy.PaymentStrategy;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeMachine {
    // ExecutorService from Java's concurrent package to handle multiple orders in parallel.

    private Inventory inventory;
    private Menu menu;
    private ExecutorService outletService;

    public CoffeeMachine(Inventory inventory, Menu menu, int outlets) {
        this.inventory = inventory;
        this.menu = menu;
        this.outletService = Executors.newFixedThreadPool(outlets);
    }

    public void selectCoffeeType(CoffeeType coffeeType, PaymentStrategy paymentStrategy){
        outletService.submit(() -> {
            synchronized (this) { // Synchronizing access to shared resources
                Recipe recipe = menu.getRecipe(coffeeType);
                if(recipe == null){
                    System.out.println("Invalid coffee selection!");
                    return;
                }
                if(!inventory.hasSufficientIngredients(recipe)){
                    System.out.println("Insufficient ingredients for " + coffeeType);
                    // return;
                    System.out.println("Refiling the stock, please wait...");

                    // Auto-refill missing ingredients
                    for(Map.Entry<Ingredient, Integer> entry: recipe.getIngredientQuantity().entrySet()){
                        Ingredient ingredient = entry.getKey();
                        int requiredAmount = entry.getValue();
                        int currentStock = inventory.getAvailableQuantity(ingredient);

                        if(currentStock < requiredAmount){
                            int refillAmount = requiredAmount - currentStock + 10;
                            refillIngredient(ingredient, refillAmount);
                            System.out.println("Auto-refilling " + ingredient.getName() + " with " + refillAmount + " units.");
                        }
                    }

                }

                double price = coffeeType.getPrice();
                paymentStrategy.pay(price);
                inventory.useIngredients(recipe);
                System.out.println(Thread.currentThread().getName() + " Dispensing " + coffeeType);
        }
        });
    }

    public void refillIngredient(Ingredient ingredient, int quantity){
        synchronized (this) {
            inventory.addStock(ingredient, quantity);
            System.out.println("Refilled " + ingredient.getName() + " with " + quantity);
        }
    }

    public void shutdownMachine() {
        outletService.shutdown(); // Shutdown thread pool
    }
}
