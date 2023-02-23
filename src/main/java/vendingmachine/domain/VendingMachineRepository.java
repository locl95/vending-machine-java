package vendingmachine.domain;

public interface VendingMachineRepository {
    VendingMachineResult acceptCoin(String coin);
    VendingMachineResult selectProduct(String product);
    String display();
}
