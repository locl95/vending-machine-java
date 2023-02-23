package vendingmachine.domain;

interface VendingMachineApp {
    VendingMachineResult acceptCoin(String coin);
    VendingMachineResult selectProduct(String product);
    String display();
}
