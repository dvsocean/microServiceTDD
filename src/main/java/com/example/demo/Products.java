package com.example.demo;

public enum Products {
  CANDY(10), SNACK(50), NUTS(90), Coke(25), Pepsi(35), Soda(45);
  private int price;

  Products(int i) {
    this.price=i;
  }

  public int getPrice() {
    return price;
  }
}
