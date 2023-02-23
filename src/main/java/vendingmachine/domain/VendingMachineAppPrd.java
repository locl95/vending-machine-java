package vendingmachine.domain;

public class VendingMachineAppPrd implements VendingMachineApp {

    private final VendingMachineRepository vendingMachine;

    public VendingMachineAppPrd(VendingMachineRepository vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public VendingMachineResult acceptCoin(String coin) {
        return vendingMachine.acceptCoin(coin);
    }

    @Override
    public String displayCoins() {
        return vendingMachine.displayCoins();
    }
}
