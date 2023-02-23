package vendingmachine.domain;

public class Product {
    String product;
    Double cost;
    Integer stock;

    public Product(String product, Double cost, Integer stock) {
        this.product = product;
        this.cost = cost;
        this.stock = stock;
    }

    public String getProduct() {
        return product;
    }

    public Double getCost() {
        return cost;
    }

    public Integer getStock() {
        return stock;
    }
}
