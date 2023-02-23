package vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.*;
import vendingmachine.drivenadapters.VendingMachineInMemory;

public class VendingMachineAppTest {

    @Test
    public void acceptCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS");
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new CoinsAdded(0.05), vendingMachineApp.acceptCoin("nickel"));
    }

    @Test
    public void displayInsertCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS");
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
    }

    @Test
    public void displayCoins() {
        VendingMachineState initialState = new VendingMachineState(2.5, 0.0, String.valueOf(2.5));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("2.5", vendingMachineApp.display());
    }

    @Test
    public void displayWhileAddingCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS");
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
        vendingMachineApp.acceptCoin("quarter");
        Assertions.assertEquals("0.25", vendingMachineApp.display());
        vendingMachineApp.acceptCoin("penny");
        Assertions.assertEquals("0.25", vendingMachineApp.display());
        vendingMachineApp.acceptCoin("nickel");
        Assertions.assertEquals("0.3", vendingMachineApp.display());
    }

    @Test
    public void selectProduct() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, String.valueOf(1.0));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new ProductSelected("cola"), vendingMachineApp.selectProduct("cola"));
    }
    @Test
    public void displayWhileSelectingProduct() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS");
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
        vendingMachineApp.acceptCoin("quarter");
        vendingMachineApp.acceptCoin("quarter");
        vendingMachineApp.acceptCoin("quarter");
        Assertions.assertEquals("0.75", vendingMachineApp.display());
        vendingMachineApp.selectProduct("cola");
        Assertions.assertEquals("PRICE 1.0", vendingMachineApp.display());
        Assertions.assertEquals("0.75", vendingMachineApp.display());
        vendingMachineApp.acceptCoin("quarter");
        Assertions.assertEquals("1.0", vendingMachineApp.display());
        vendingMachineApp.selectProduct("cola");
        Assertions.assertEquals("THANK YOU", vendingMachineApp.display());
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());


    }


}