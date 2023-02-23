package vendingmachine.domain;

public class Product {
    String product;
    Double cost;

    public Product(String product, Double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public Double getCost() {
        return cost;
    }
}
