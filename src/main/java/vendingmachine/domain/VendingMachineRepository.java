package vendingmachine.domain;

public interface VendingMachineRepository {
    VendingMachineResult acceptCoin(String coin);
    String displayCoins();
}
