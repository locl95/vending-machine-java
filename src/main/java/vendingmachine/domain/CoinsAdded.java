package vendingmachine.domain;

public class CoinsAdded implements VendingMachineResult {
    Double coins;

    public Double getCoins() {
        return coins;
    }

    public CoinsAdded(Double coins) {
        this.coins = coins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinsAdded that = (CoinsAdded) o;

        return coins.equals(that.coins);
    }

    @Override
    public int hashCode() {
        return coins.hashCode();
    }

    @Override
    public String toString() {
        return "CoinsAdded{" +
                "coins=" + coins +
                '}';
    }
}
