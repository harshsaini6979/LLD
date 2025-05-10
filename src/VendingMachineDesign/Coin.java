package VendingMachineDesign;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    TWOHUNDRED(200);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Coin getNameByValue(int value) {
        for (Coin coin : Coin.values()) {
            if (coin.getValue() == value) {
                return coin;
            }
        }
        return null; // or throw an exception if the value is invalid
    }
}