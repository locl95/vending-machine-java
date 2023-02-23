package vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.CoinsAdded;
import vendingmachine.domain.VendingMachineAppPrd;
import vendingmachine.domain.VendingMachineRepository;
import vendingmachine.domain.VendingMachineState;
import vendingmachine.drivenadapters.VendingMachineInMemory;

public class VendingMachineAppTest {

    @Test
    public void acceptCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0);
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new CoinsAdded(0.05), vendingMachineApp.acceptCoin("nickel"));
    }

    @Test
    public void displayInsertCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0);
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.displayCoins());
    }

    @Test
    public void displayCoins() {
        VendingMachineState initialState = new VendingMachineState(2.50, 0.0);
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("2.5", vendingMachineApp.displayCoins());
    }

    @Test
    public void displayCoinsWhileUpdating() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0);
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.displayCoins());
        vendingMachineApp.acceptCoin("quarter");
        Assertions.assertEquals("0.25", vendingMachineApp.displayCoins());
        vendingMachineApp.acceptCoin("penny");
        Assertions.assertEquals("0.25", vendingMachineApp.displayCoins());
        vendingMachineApp.acceptCoin("nickel");
        Assertions.assertEquals("0.3", vendingMachineApp.displayCoins());
    }
}