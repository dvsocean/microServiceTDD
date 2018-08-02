package com.example.demo.restAssured;

import static org.hamcrest.Matchers.equalTo;

import com.example.demo.Products;
import io.restassured.RestAssured;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class RestAssuredTests {

  private int[] products = new int[]{10, 50, 90, 25, 35, 45};
  private Random random = new Random();
  private int index = random.nextInt(products.length);

  @Before
  public void setup(){
    RestAssured.baseURI = "http://localhost:8080";
  }

//  @Test
//  public void restAssuredForPennies(){
//    RestAssured
//        .given()
//        .param("coin","1")
//        .when()
//        .post("/insertCoin")
//        .then()
//        .statusCode(200)
//        .body("status", equalTo(true));
//
//  }
//
//  @Test
//  public void restAssuredForNickleValue(){
//    RestAssured.given().param("coin", 5).then()
//        .statusCode(200).body("status", equalTo(true));
//  }
//
//  @Test
//  public void restAssuredDimeTest(){
//    RestAssured.given().param("coin", 10)
//        .when()
//        .post("/insertCoin")
//        .then()
//        .body("status", equalTo(true)).log().all();
//  }

  @Test
  public void restDollarNote(){
    RestAssured.given().param("note", 1).when()
        .post("/insertNote").then()
        .body("status", equalTo(true));
  }

  @Test
  public void shouldAllowUserToSelectProduct(){
    RestAssured.given().param("product", products[index])
        .post("/selectProduct").then().body("status", equalTo(true));
  }

  @Test
  public void shouldAllowUserToReceiveRefund(){
    RestAssured.given().param("product", Products.CANDY).post("/addProduct");
    RestAssured.given().param("product", Products.Coke).post("/addProduct");
    RestAssured.given().post("/refundProducts").then().body("price", equalTo(35));
  }

  @Test
  public void shouldGiveProductAndGiveChangeIfAnyUponPurchase(){
    RestAssured.given().param("product", Products.SNACK, Products.SNACK, Products.CANDY)
        .param("money", 139)
        .when().post("/completeTransaction").then().log().all();
  }

  //Allow reset operation for vending machine supplier
  @Test
  public void shouldAllowResetOperationForSupplier(){

  }





}
