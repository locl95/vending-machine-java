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
    public VendingMachineResult acceptCoin(String coin) {

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
                 state = new VendingMachineState(state.getAddedCoins() + c, state.getCoinsToReturn());
                 return new CoinsAdded(c);
             }
             else {
                 state = new VendingMachineState(state.getAddedCoins(), state.getCoinsToReturn() + c);
                 return new CoinsToReturn(c);
             }
        }
        else return new VendingMachineError("Unknown Coin");
    }

    @Override
    public String displayCoins() {
        if (state.getAddedCoins() == 0) return "INSERT COINS";
        return state.getAddedCoins().toString();
    }
}
