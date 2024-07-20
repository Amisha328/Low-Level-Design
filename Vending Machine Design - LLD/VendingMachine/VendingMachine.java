package VendingMachine;

import VendingMachine.Entity.Inventory;
import VendingMachine.Enum.Coins;
import VendingMachine.States.IdealState;
import VendingMachine.States.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    Inventory inventory;
    State state;
    List<Coins> coinsList;

    public VendingMachine(int size) {
        inventory = new Inventory(size);
        coinsList = new ArrayList<>();
        state = new IdealState();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Coins> getCoinsList() {
        return coinsList;
    }

    public void setCoinsList(List<Coins> coinsList) {
        this.coinsList = coinsList;
    }
}
