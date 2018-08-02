package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class LocalVendingMachineTests {

  private VendingMachine vendingMachine;
  private Random random;
  private int[] products = new int[]{10, 50, 90, 25, 35, 45};
  private int index;

  @Before
  public void setup(){
    vendingMachine = new VendingMachine();
    this.random = new Random();
    this.index = random.nextInt(products.length);
  }

  @Test
  public void shouldAcceptPennies(){
    vendingMachine.insertCoin(1);
    assertEquals(1, vendingMachine.getLastInsertedCoinValue());
  }

  @Test
  public void shouldAcceptNickles(){
    vendingMachine.insertCoin(5);
    assertEquals(5, vendingMachine.getLastInsertedCoinValue());
  }

  @Test
  public void shouldAcceptDimes(){
    vendingMachine.insertCoin(10);
    assertEquals(10, vendingMachine.getLastInsertedCoinValue());
  }

  @Test
  public void shouldAcceptQuarters(){
    vendingMachine.insertCoin(25);
    assertEquals(25, vendingMachine.getLastInsertedCoinValue());
  }

  @Test
  public void shouldAcceptOneDollarBills(){
    vendingMachine.insertNote(1);
    assertEquals(1, vendingMachine.getLastInsertedNoteValue());
  }

  @Test
  public void shouldAcceptTwoDollarBills(){
    vendingMachine.insertNote(2);
    assertEquals(2, vendingMachine.getLastInsertedNoteValue());
  }

  @Test
  public void shouldAllowUserToSelectProduct(){
    vendingMachine.selectProduct(products[index]);
    assertTrue(vendingMachine.isProductSelected());
  }

  //Allow reset operation for vending machine supplier
  @Test
  public void shouldAllowResetOperationForSupplier(){
    vendingMachine.unplug();
    vendingMachine.plugBackInAndResetSystem();
    assertEquals(220, vendingMachine.getVoltage());
  }
}
