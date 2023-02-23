package vendingmachine.domain;

interface VendingMachineApp {
    VendingMachineResult acceptCoin(String coin);
    String displayCoins();
}
