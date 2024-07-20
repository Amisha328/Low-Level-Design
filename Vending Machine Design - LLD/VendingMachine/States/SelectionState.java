package VendingMachine.States;

import VendingMachine.Entity.Inventory;
import VendingMachine.Entity.Item;
import VendingMachine.Enum.Coins;
import VendingMachine.VendingMachine;

import java.util.List;

public class SelectionState implements State{
    public SelectionState() {
        System.out.println("Currently in the product Selection State");
    }

    @Override
    public void clickOnInsertCoinsButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Invalid operation, cannot click on insert coins button at selection state");
    }

    @Override
    public List<Coins> refundCoins(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refund the total amount, due to insufficient balance");
        return vendingMachine.getCoinsList();
    }

    @Override
    public int returnChange(VendingMachine vendingMachine, int amount) throws Exception {
        System.out.println("Returned balance amount of " + amount + " to the user");
        return  amount;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("Cannot dispense product in selection state");
    }

    @Override
    public void enterItemCode(VendingMachine vendingMachine, int itemCode) throws Exception {
        Inventory inventory = vendingMachine.getInventory();
        Item item = inventory.getItem(itemCode);
        List<Coins> coinList = vendingMachine.getCoinsList();
        int currentAmount = 0;
        for(Coins coin: coinList){
            currentAmount += coin.getValue();
        }

        if(item.getPrice() <= currentAmount){
            vendingMachine.setState(new DispenseState(vendingMachine, itemCode));
            returnChange(vendingMachine, currentAmount - item.getPrice());
        }
        else {
            refundCoins(vendingMachine);
            throw new Exception("Insufficient balance to purchase this item");
        }
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Invalid operation, Already in selection state");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coins coin) throws Exception {
        throw new Exception("Invalid operation, cannot insert coins at selection state");
    }
}
