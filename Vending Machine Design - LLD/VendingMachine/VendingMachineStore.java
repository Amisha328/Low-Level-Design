package VendingMachine;

import VendingMachine.Entity.Inventory;
import VendingMachine.Entity.Item;
import VendingMachine.Entity.ItemShelf;
import VendingMachine.Enum.Coins;
import VendingMachine.Enum.ItemType;
import VendingMachine.States.State;

import java.util.List;

public class VendingMachineStore {
    public static void main(String[] args) throws Exception {
        int size = 10;
        VendingMachine vendingMachine = new VendingMachine(size);
        populateVendingMachine(vendingMachine,size);

        // Insert coins
        State currentState = vendingMachine.getState();
        currentState.clickOnInsertCoinsButton(vendingMachine);

        currentState = vendingMachine.getState();
        currentState.insertCoins(vendingMachine, Coins.TEN);
        currentState.insertCoins(vendingMachine, Coins.TEN);

        // Choose product
        currentState.clickOnSelectItemButton(vendingMachine);

        // Selection state and dispense product
        currentState = vendingMachine.getState();
        currentState.enterItemCode(vendingMachine, 101);
    }

    private static void populateVendingMachine(VendingMachine vendingMachine, int size){
        ItemShelf[] inventory = vendingMachine.getInventory().getInventory();
        for(int index = 0; index < size; index++){
            if(index < 4){
                Item item = new Item();
                item.setItemType(ItemType.COKE);
                item.setPrice(ItemType.COKE.getValue());
                inventory[index].setAvailable(true);
                inventory[index].setItem(item);
            }
            else if(index >= 4 && index <= 6){
                Item item = new Item();
                item.setItemType(ItemType.LAYS);
                item.setPrice(ItemType.LAYS.getValue());
                inventory[index].setItem(item);
                inventory[index].setAvailable(true);
            }
            else if(index >= 7 && index <= 8){
                Item item = new Item();
                item.setItemType(ItemType.PEPSI);
                item.setPrice(ItemType.PEPSI.getValue());
                inventory[index].setItem(item);
                inventory[index].setAvailable(true);
            }
            else{
                Item item = new Item();
                item.setItemType(ItemType.BINGO);
                item.setPrice(ItemType.BINGO.getValue());
                inventory[index].setItem(item);
                inventory[index].setAvailable(true);
            }
        }

        displayVendingMachine(vendingMachine);
    }

    private static void displayVendingMachine(VendingMachine vendingMachine){
        ItemShelf[] inventory = vendingMachine.getInventory().getInventory();
        for(ItemShelf itemShelf: inventory){
            Item item = itemShelf.getItem();
            System.out.println("Item type is: " + item.getItemType() + " item price is: "+ item.getPrice() + " item code is: " + itemShelf.getItemCode());
        }
    }
}
