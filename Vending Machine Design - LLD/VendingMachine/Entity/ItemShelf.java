package VendingMachine.Entity;

public class ItemShelf {
    Item item;
    int itemCode;
    boolean isAvailable;

    public ItemShelf(int itemCode) {
        this.itemCode = itemCode;
        this.isAvailable = false;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
