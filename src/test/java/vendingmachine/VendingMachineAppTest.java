package vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.*;
import vendingmachine.drivenadapters.VendingMachineInMemory;

import java.util.List;

public class VendingMachineAppTest {

    @Test
    public void acceptCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new CoinsAdded(0.05), vendingMachineApp.insertCoin("nickel"));
    }

    @Test
    public void displayInsertCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
    }

    @Test
    public void displayCoins() {
        VendingMachineState initialState = new VendingMachineState(2.5, 0.0, String.valueOf(2.5), List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("2.5", vendingMachineApp.display());
    }

    @Test
    public void displayWhileAddingCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
        vendingMachineApp.insertCoin("quarter");
        Assertions.assertEquals("0.25", vendingMachineApp.display());
        vendingMachineApp.insertCoin("penny");
        Assertions.assertEquals("0.25", vendingMachineApp.display());
        vendingMachineApp.insertCoin("nickel");
        Assertions.assertEquals("0.3", vendingMachineApp.display());
    }

    @Test
    public void selectProduct() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, String.valueOf(1.0), List.of(new Product("cola", 1.0,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new ProductSelected("cola"), vendingMachineApp.selectProduct("cola"));
    }
    @Test
    public void selectSoldOutProduct() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, String.valueOf(1.0), List.of(new Product("cola", 1.0,0)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new VendingMachineError("Product Sold Out: cola"), vendingMachineApp.selectProduct("cola"));
    }
    @Test
    public void displayWhileSelectingProduct() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS", List.of(new Product("cola", 1.0,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
        vendingMachineApp.insertCoin("quarter");
        vendingMachineApp.insertCoin("quarter");
        vendingMachineApp.insertCoin("quarter");
        Assertions.assertEquals("0.75", vendingMachineApp.display());
        vendingMachineApp.selectProduct("cola");
        Assertions.assertEquals("PRICE 1.0", vendingMachineApp.display());
        Assertions.assertEquals("0.75", vendingMachineApp.display());
        vendingMachineApp.insertCoin("quarter");
        Assertions.assertEquals("1.0", vendingMachineApp.display());
        vendingMachineApp.selectProduct("cola");
        Assertions.assertEquals("THANK YOU", vendingMachineApp.display());
        Assertions.assertEquals("INSERT COINS", vendingMachineApp.display());
    }

    @Test
    public void returnCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 1.0, "INSERT COINS", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new CoinsReturned(1.0), vendingMachineApp.returnCoins());
    }

    @Test
    public void returnCoinsIfIChangeMyMind() {
        VendingMachineState initialState = new VendingMachineState(1.0, 1.0, "INSERT COINS", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        VendingMachineAppPrd vendingMachineApp = new VendingMachineAppPrd(vendingMachineRepository);
        Assertions.assertEquals(new CoinsReturned(2.0), vendingMachineApp.returnCoins());
    }


}