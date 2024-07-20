package VendingMachine.Enum;

public enum ItemType {
    COKE(20),
    LAYS(10),
    PEPSI(25),
    BINGO(20);

    int value;

    ItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



}
