package vendingmachine.domain;

public class Coin {
    Double value;
    String type;

    public Coin(Double value, String type) {
        this.value = value;
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
