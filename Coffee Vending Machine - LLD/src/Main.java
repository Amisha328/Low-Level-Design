import Entity.*;
import Enum.CoffeeType;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Ingredient coffee = new Ingredient("Coffee");
        Ingredient milk = new Ingredient("Milk");
        Ingredient sugar = new Ingredient("Sugar");
        Ingredient water = new Ingredient("Water");

        HashMap<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(coffee, 2);
        espressoRecipe.put(water, 2);

        HashMap<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(coffee, 1);
        cappuccinoRecipe.put(milk, 2);
        cappuccinoRecipe.put(sugar, 1);
        cappuccinoRecipe.put(water, 1);

        HashMap<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(coffee, 2);
        latteRecipe.put(milk, 1);
        latteRecipe.put(water, 1);

        Menu menu = new Menu();
        menu.addCoffeeInMenu(CoffeeType.ESPRESSO, new Recipe(espressoRecipe));
        menu.addCoffeeInMenu(CoffeeType.CAPPUCCINO, new Recipe(cappuccinoRecipe));
        menu.addCoffeeInMenu(CoffeeType.LATTE, new Recipe(latteRecipe));

        menu.displayMenu();

        Inventory inventory = new Inventory();
        inventory.addStock(coffee, 5);
        inventory.addStock(milk, 5);
        inventory.addStock(sugar, 2);
        inventory.addStock(water, 5);

        CoffeeMachine coffeeMachine = new CoffeeMachine(inventory, menu, 3);
        coffeeMachine.selectCoffeeType(CoffeeType.ESPRESSO, new CardPayment());
        coffeeMachine.selectCoffeeType(CoffeeType.CAPPUCCINO, new CardPayment());
        coffeeMachine.selectCoffeeType(CoffeeType.LATTE, new CashPayment());
        coffeeMachine.selectCoffeeType(CoffeeType.ESPRESSO, new UPIPayment());

        coffeeMachine.shutdownMachine();
    }
}