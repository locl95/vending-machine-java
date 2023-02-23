package vendingmachine.domain;

public class CoinsReturned implements VendingMachineResult {
    double value;
    public CoinsReturned(double v) {
        this.value = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinsReturned that = (CoinsReturned) o;

        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "CoinsReturned{" +
                "value=" + value +
                '}';
    }
}
