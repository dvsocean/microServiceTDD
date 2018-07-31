package com.example.demo;

import java.util.List;

public class MyResponse {

  private Boolean status;

  private Integer price;

  private List<Products> returnProducts;

  public MyResponse(Boolean status) {
    this.status = status;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public List<Products> getReturnProducts() {
    return returnProducts;
  }

  public void setReturnProducts(List<Products> returnProducts) {
    this.returnProducts = returnProducts;
  }
}
