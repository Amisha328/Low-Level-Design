package VendingMachine.States;

import VendingMachine.Entity.Item;
import VendingMachine.Enum.Coins;
import VendingMachine.VendingMachine;

import java.util.List;

public interface State {
    public void clickOnInsertCoinsButton(VendingMachine vendingMachine)  throws Exception;

    public void insertCoins(VendingMachine vendingMachine, Coins coin)  throws Exception;

    public void clickOnSelectItemButton(VendingMachine vendingMachine)  throws Exception;

    public void enterItemCode(VendingMachine vendingMachine, int itemCode)  throws Exception;

    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode)  throws Exception;

    public int returnChange(VendingMachine vendingMachine, int amount)  throws Exception;

    public List<Coins> refundCoins(VendingMachine vendingMachine)  throws Exception;

}
