package vendingmachine.domain;

import java.util.List;

public class VendingMachineState {
    private final Double addedCoins;
    private final Double coinsToReturn;
    private final String display;
    List<Product> products;

    public VendingMachineState(Double addedCoins, Double coinsToReturn, String display, List<Product> products) {
        this.addedCoins = addedCoins;
        this.coinsToReturn = coinsToReturn;
        this.display = display;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getCoinsToReturn() {
        return coinsToReturn;
    }

    public Double getAddedCoins() {
        return addedCoins;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendingMachineState that = (VendingMachineState) o;

        if (!addedCoins.equals(that.addedCoins)) return false;
        if (!coinsToReturn.equals(that.coinsToReturn)) return false;
        return display.equals(that.display);
    }

    @Override
    public int hashCode() {
        int result = addedCoins.hashCode();
        result = 31 * result + coinsToReturn.hashCode();
        result = 31 * result + display.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VendingMachineState{" +
                "addedCoins=" + addedCoins +
                ", coinsToReturn=" + coinsToReturn +
                ", display='" + display + '\'' +
                '}';
    }
}
