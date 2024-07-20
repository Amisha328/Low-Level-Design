package VendingMachine.Entity;

public class Inventory {

    ItemShelf[] inventory;


    public Inventory(int size) {
        this.inventory = new ItemShelf[size];
        int code = 101;
        for(int index = 0; index < size; index++){
            ItemShelf itemShelf = new ItemShelf(code);
            inventory[index] = itemShelf;
            code++;
        }
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public Item getItem(int code) throws Exception{
        for(ItemShelf itemShelf: inventory){
            if(itemShelf.getItemCode() == code){
                if(itemShelf.isAvailable()){
                    return itemShelf.getItem();
                }
                else {
                    throw new Exception("Item is not available");
                }
            }
        }
        throw new Exception(("Invalid item code entered"));
    }
}
