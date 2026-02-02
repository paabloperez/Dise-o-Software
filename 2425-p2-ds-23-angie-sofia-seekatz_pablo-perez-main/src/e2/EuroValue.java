package e2;

public enum EuroValue { EURO200 (200), EURO100 (100), EURO50 (50), EURO20 (20), EURO10 (10), EURO5 (5), EURO2 (2), EURO1 (1);
    private int value;


    EuroValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
