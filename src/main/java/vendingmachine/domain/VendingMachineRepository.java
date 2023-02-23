package vendingmachine.domain;

public interface VendingMachineRepository {
    VendingMachineResult insertCoin(String coin);
    VendingMachineResult returnCoins();
    VendingMachineResult selectProduct(String product);
    String display();

    VendingMachineState getState();
}
