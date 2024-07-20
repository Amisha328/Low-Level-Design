package VendingMachine.States;

import VendingMachine.Entity.Item;
import VendingMachine.Enum.Coins;
import VendingMachine.VendingMachine;

import java.util.List;

public class DispenseState implements State{
    public DispenseState(VendingMachine vendingMachine, int itemCode) throws Exception {
        System.out.println("Currently in dispense state");
        dispenseProduct(vendingMachine, itemCode);
    }

    @Override
    public void clickOnInsertCoinsButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Invalid operation, Cannot click on insert coin button in product dispense state");
    }

    @Override
    public List<Coins> refundCoins(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot cancel operation in product dispense state");
    }

    @Override
    public int returnChange(VendingMachine vendingMachine, int amount) throws Exception {
        throw new Exception("Invalid operation, Cannot return change in product dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        Item item = vendingMachine.getInventory().getItem(itemCode);
        System.out.println("Dispensing the product with code: "+itemCode+" and item type: " + item.getItemType());
        return item;
    }

    @Override
    public void enterItemCode(VendingMachine vendingMachine, int itemCode) throws Exception {
        throw new Exception("Invalid operation, Cannot enter item code in product dispense state");
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Invalid operation, Cannot select item in product dispense state");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coins coin) throws Exception {
        throw new Exception("Invalid operation, Cannot insert coins in product dispense state");
    }
}
