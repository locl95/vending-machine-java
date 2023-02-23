package vendingmachine.drivenadapters;

import vendingmachine.domain.*;

import java.util.List;
import java.util.Optional;

public class VendingMachineInMemory implements VendingMachineRepository {
    private VendingMachineState state;

    public VendingMachineInMemory(VendingMachineState initialState) {
        this.state = initialState;
    }

    @Override
    public VendingMachineResult insertCoin(String coin) {

        List<Coin> acceptedCoins = List
            .of(new Coin(0.05,"nickel"),
                new Coin(0.10,"dime"),
                new Coin(0.25,"quarter"),
                new Coin(0.01,"penny")
            );

        Optional<Coin> maybeCoin = acceptedCoins.stream().filter( (cc) -> cc.getType().equals(coin)).findFirst();

        if (maybeCoin.isPresent()) {
             Coin cc = maybeCoin.get();
             Double c = cc.getValue();
             if(cc.getValue() != 0.01) {
                 double addedCoins = state.getAddedCoins() + c;
                 state = new VendingMachineState(addedCoins, state.getCoinsToReturn(), String.valueOf(addedCoins));
                 return new CoinsAdded(c);
             }
             else {
                 state = new VendingMachineState(state.getAddedCoins(), state.getCoinsToReturn() + c, state.getDisplay());
                 return new CoinsToReturn(c);
             }
        }
        else return new VendingMachineError("Unknown Coin: " + coin);
    }

    @Override
    public VendingMachineResult returnCoins() {
        double coinsToReturn = state.getCoinsToReturn();
        state = new VendingMachineState(state.getAddedCoins(), 0.0, state.getDisplay());
        return new CoinsReturned(coinsToReturn);
    }

    @Override
    public VendingMachineResult selectProduct(String product) {
        List<Product> products = List
                .of(new Product("cola",1.0),
                    new Product("chips",0.5),
                    new Product("candy",0.65)
                );

        Optional<Product> maybeProduct = products.stream().filter( (cc) -> cc.getProduct().equals(product)).findFirst();
        if (maybeProduct.isPresent()) {
            Product p = maybeProduct.get();
            if (state.getAddedCoins() >= p.getCost()) {
                state = new VendingMachineState(0.0, state.getCoinsToReturn() + state.getAddedCoins() - p.getCost(), "THANK YOU");
                return new ProductSelected(product);
            }
            else {
                state = new VendingMachineState(state.getAddedCoins(), state.getCoinsToReturn(), "PRICE "+ p.getCost());
                return new VendingMachineError("Not Enough Money: " + state.getAddedCoins() + "/" + p.getCost());
            }
        }
        else return new VendingMachineError("Unknown Product: " + product);
    }

    private String calculateDisplay(String currentDisplay) {
        if(currentDisplay.contains("PRICE") && state.getAddedCoins() > 0) return String.valueOf(state.getAddedCoins());
        return "INSERT COINS";
    }

    @Override
    public String display() {
        String currentDisplay = state.getDisplay();
        state = new VendingMachineState(state.getAddedCoins(), state.getCoinsToReturn(), calculateDisplay(currentDisplay));
        return currentDisplay;
    }

    @Override
    public VendingMachineState getState() {
        return state;
    }
}
