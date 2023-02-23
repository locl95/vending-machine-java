package vendingmachine.domain;

public class CoinsToReturn implements VendingMachineResult {
    Double coins;

    public Double getCoins() {
        return coins;
    }

    public CoinsToReturn(Double coins) {
        this.coins = coins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinsToReturn that = (CoinsToReturn) o;

        return coins.equals(that.coins);
    }

    @Override
    public int hashCode() {
        return coins.hashCode();
    }

    @Override
    public String toString() {
        return "CoinstoReturn{" +
                "coins=" + coins +
                '}';
    }
}
