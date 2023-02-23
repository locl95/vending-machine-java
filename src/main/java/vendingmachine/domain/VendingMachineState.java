package vendingmachine.domain;

public class VendingMachineState {
    private final Double addedCoins;
    private final Double coinsToReturn;

    public VendingMachineState(Double addedCoins, Double coinsToReturn) {
        this.addedCoins = addedCoins;
        this.coinsToReturn = coinsToReturn;
    }

    public Double getCoinsToReturn() {
        return coinsToReturn;
    }

    public Double getAddedCoins() {
        return addedCoins;
    }





}
