package vendingmachine.domain;

public interface VendingMachineRepository {
    VendingMachineResult insertCoin(String coin);
    VendingMachineResult selectProduct(String product);
    String display();

    VendingMachineState getState();
}
