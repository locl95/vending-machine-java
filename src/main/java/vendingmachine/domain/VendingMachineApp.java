package vendingmachine.domain;

interface VendingMachineApp {
    VendingMachineResult insertCoin(String coin);
    VendingMachineResult selectProduct(String product);
    VendingMachineResult returnCoins();
    String display();
}
