package vendingmachine.domain;

interface VendingMachineApp {
    VendingMachineResult insertCoin(String coin);
    VendingMachineResult selectProduct(String product);
    String display();
}
