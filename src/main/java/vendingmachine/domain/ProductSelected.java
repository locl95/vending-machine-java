package vendingmachine.domain;

public class ProductSelected implements VendingMachineResult {
    String product;

    public ProductSelected(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSelected that = (ProductSelected) o;

        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    @Override
    public String toString() {
        return "ProductSelected{" +
                "product='" + product + '\'' +
                '}';
    }
}
