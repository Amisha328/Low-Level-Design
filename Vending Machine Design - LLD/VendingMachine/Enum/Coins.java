package VendingMachine.Enum;

public enum Coins {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    int value;

    Coins(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
