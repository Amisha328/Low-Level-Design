package VendingMachine.States;

import VendingMachine.Entity.Item;
import VendingMachine.Enum.Coins;
import VendingMachine.VendingMachine;

import java.util.List;

public class ReadyState implements State{
    public ReadyState() {
        System.out.println("Currently in the Ready State");
    }

    @Override
    public void clickOnInsertCoinsButton(VendingMachine vendingMachine) throws Exception{
            throw new Exception("Invalid operation, we cannot click on insert coins button again");
    }

    @Override
    public List<Coins> refundCoins(VendingMachine vendingMachine)  throws Exception{
            System.out.println("Clicked on Cancel Button");
            return vendingMachine.getCoinsList();
    }

    @Override
    public int returnChange(VendingMachine vendingMachine, int amount)  throws Exception {
        throw new Exception("Invalid operation, no change to return in Ideal State");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode)  throws Exception {
        throw new Exception("Invalid operation, cannot click on insert coins button again");
    }

    @Override
    public void enterItemCode(VendingMachine vendingMachine, int itemCode)  throws Exception{
        throw new Exception("Invalid operation, cannot click on enter item code in ready state");
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vendingMachine)  throws Exception{
        System.out.println("Click on the select Item Button");
        vendingMachine.setState(new SelectionState());
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coins coin)  throws Exception{
        System.out.println("Coins inserted of value " + coin.getValue());
        List<Coins> coinsList = vendingMachine.getCoinsList();
        coinsList.add(coin);
        vendingMachine.setCoinsList(coinsList);
    }
}
