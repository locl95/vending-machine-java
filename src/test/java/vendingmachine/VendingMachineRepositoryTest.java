package vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.*;
import vendingmachine.drivenadapters.VendingMachineInMemory;

import java.util.List;

public class VendingMachineRepositoryTest {

    @Test
    public void acceptCoins() {
        VendingMachineState initialState = new VendingMachineState(0.0, 0.0, "INSERT COINS", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new CoinsAdded(0.05), vendingMachineRepository.insertCoin("nickel"));
        Assertions.assertEquals(new CoinsAdded(0.10), vendingMachineRepository.insertCoin("dime"));
        Assertions.assertEquals(new CoinsAdded(0.25), vendingMachineRepository.insertCoin("quarter"));
        Assertions.assertEquals(new CoinsToReturn(0.01), vendingMachineRepository.insertCoin("penny"));
        Assertions.assertEquals(new VendingMachineError("Unknown Coin: euro"), vendingMachineRepository.insertCoin("euro"));
        Assertions.assertEquals(new VendingMachineState(0.4, 0.01, "0.4", List.of()), vendingMachineRepository.getState());
    }

    @Test
    public void selectCola() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, "1.0", List.of(new Product("cola", 1.0,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new ProductSelected("cola"), vendingMachineRepository.selectProduct("cola"));
    }
    @Test
    public void selectCandy() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, "1.0", List.of(new Product("candy", 0.65,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new ProductSelected("candy"), vendingMachineRepository.selectProduct("candy"));
    }
    @Test
    public void selectChips() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, "1.0", List.of(new Product("chips", 0.5,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new ProductSelected("chips"), vendingMachineRepository.selectProduct("chips"));
    }
    @Test
    public void selectWater() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, "1.0", List.of());
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new VendingMachineError("Unknown Product: water"), vendingMachineRepository.selectProduct("water"));
    }
    @Test
    public void selectColaWithoutEnoughMoney() {
        VendingMachineState initialState = new VendingMachineState(0.75, 0.0, "0.75", List.of(new Product("cola", 1.0,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        Assertions.assertEquals(new VendingMachineError("Not Enough Money: 0.75/1.0"), vendingMachineRepository.selectProduct("cola"));
    }

    @Test
    public void changeIsCalculatedCorrectly() {
        VendingMachineState initialState = new VendingMachineState(1.0, 0.0, "1.0", List.of(new Product("chips", 0.5,1)));
        VendingMachineRepository vendingMachineRepository = new VendingMachineInMemory(initialState);
        vendingMachineRepository.selectProduct("chips");
        Assertions.assertEquals(new VendingMachineState(0.0, 0.5, "THANK YOU", List.of(new Product("cola", 1.0,0))), vendingMachineRepository.getState());
    }


}