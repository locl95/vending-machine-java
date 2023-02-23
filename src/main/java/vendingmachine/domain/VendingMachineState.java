package vendingmachine.domain;

public class VendingMachineState {
    private final Double addedCoins;
    private final Double coinsToReturn;
    private final String display;

    public VendingMachineState(Double addedCoins, Double coinsToReturn, String display) {
        this.addedCoins = addedCoins;
        this.coinsToReturn = coinsToReturn;
        this.display = display;
    }

    public Double getCoinsToReturn() {
        return coinsToReturn;
    }

    public Double getAddedCoins() {
        return addedCoins;
    }

    public String getDisplay() {
        return display;
    }
}
