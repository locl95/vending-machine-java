package vendingmachine.domain;

public class VendingMachineAppPrd implements VendingMachineApp {

    private final VendingMachineRepository vendingMachine;

    public VendingMachineAppPrd(VendingMachineRepository vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public VendingMachineResult insertCoin(String coin) {
        return vendingMachine.insertCoin(coin);
    }

    @Override
    public VendingMachineResult selectProduct(String product) {
        return vendingMachine.selectProduct(product);
    }

    @Override
    public VendingMachineResult returnCoins() {
        return vendingMachine.returnCoins();
    }

    @Override
    public String display() {
        return vendingMachine.display();
    }
}
