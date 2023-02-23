package vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.*;
import vendingmachine.drivenadapters.VendingMachineInMemory;

public class VendingMachineRepositoryTest {

    @Test
    public void acceptCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0);
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new CoinsAdded(0.05), vendingMachineRepository.acceptCoin("nickel"));
        Assertions.assertEquals(new CoinsAdded(0.10), vendingMachineRepository.acceptCoin("dime"));
        Assertions.assertEquals(new CoinsAdded(0.25), vendingMachineRepository.acceptCoin("quarter"));
        Assertions.assertEquals(new CoinsToReturn(0.01), vendingMachineRepository.acceptCoin("penny"));
        Assertions.assertEquals(new VendingMachineError("Unknown Coin"), vendingMachineRepository.acceptCoin("euro"));
    }
}