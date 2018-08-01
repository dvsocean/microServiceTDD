package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MondayTdd {

  public static MondayTdd mondayTdd = new MondayTdd();

  private int coinValue;
  private int noteValue;
  private int product;
  private List<Products> cart = new ArrayList<>();
  private int totalPrice;

  public MyResponse insertCoin(int value) {

    if (value == 1 || value == 5 || value == 10 || value == 25) {
      this.coinValue = value;
      return new MyResponse(true);
    }
    return new MyResponse(false);
  }

  public MyResponse insertBill(int value) {
    if (value == 1 || value == 2) {
      this.noteValue = value;
      return new MyResponse(true);
    }
    return new MyResponse(false);
  }

  public int getLastInsertedCoinValue() {
    return this.coinValue;
  }

  public int getLastInsertedNoteValue() {
    return this.noteValue;
  }

  public void insertNote(int noteValue) {
    this.noteValue = noteValue;
  }

  public MyResponse selectProduct(int product) {
    this.product = product;
    return new MyResponse(true);
  }

  public int getSelectedProduct() {
    return this.product;
  }

  public boolean isInteger(String s) {
    boolean isValidInteger = false;
    try {
      Integer.parseInt(s);
      isValidInteger = true;
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
    }
    return isValidInteger;
  }

  public boolean isProductSelected() {
    int selected = getSelectedProduct();
    return false;
  }

  public MyResponse addProduct(Products item) {
    cart.add(item);
    totalPrice += item.getPrice();
    return new MyResponse(true);
  }

  public MyResponse cancelTransaction() {
    MyResponse myResponse = new MyResponse(false);
    cart.clear();
    if (cart.isEmpty()) {
      myResponse = new MyResponse(true);
      myResponse.setPrice(totalPrice);
      totalPrice = 0;
    }
    return myResponse;
  }

  public void clearShoppingCart() {
    cart.clear();
    totalPrice = 0;
  }

  public List<Products> getCart() {
    return cart;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public MyResponse completeTransaction(List<Products> products, Integer money) {
    for (Products product : products) {
      MondayTdd.mondayTdd.addProduct(product);
    }
    MyResponse myResponse = new MyResponse(true);
    myResponse.setPrice(money - MondayTdd.mondayTdd.getTotalPrice());
    myResponse.setReturnProducts(MondayTdd.mondayTdd.getCart());
    //MondayTdd.mondayTdd.clearShoppingCart();

    return myResponse;
  }
}
