package VendingMachine.States;

import VendingMachine.Entity.Item;
import VendingMachine.Enum.Coins;
import VendingMachine.VendingMachine;

import java.util.List;

public class IdealState implements State{
    public IdealState() {
        System.out.println("Currently in the Ideal State");
    }

    @Override
    public void clickOnInsertCoinsButton(VendingMachine vendingMachine)  throws Exception{
        System.out.println("Click on the Insert Coin Button and changing the state from Ideal to Ready");
        vendingMachine.setState(new ReadyState());
    }

    @Override
    public List<Coins> refundCoins(VendingMachine vendingMachine)  throws Exception{
        throw new Exception("Invalid operation, cannot refund money in Idle state");
    }

    @Override
    public int returnChange(VendingMachine vendingMachine, int amount)  throws Exception{
        throw new Exception("Invalid operation, we cannot click on insert coins button again");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode)  throws Exception{
        throw new Exception("Invalid operation, cannot dispense the product in Idle state");
    }

    @Override
    public void enterItemCode(VendingMachine vendingMachine, int itemCode)  throws Exception{
        throw new Exception("Invalid operation, cannot enter product code in Idle state");
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vendingMachine)  throws Exception{
        throw new Exception("Invalid operation, cannot select item in Idle state");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coins coin)  throws Exception{
        throw new Exception("Invalid operation, we cannot insert coin in Ideal state");
    }
}
