package com.example.demo;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MondayControllerTest {

  private MondayTdd vendingMachine;
  private Random random;
  private int[] products = new int[]{10, 50, 90, 25, 35, 45};
  private int index;

  @Autowired
  private MockMvc mockMvc;

  public void MondayTdd(){
    vendingMachine = new MondayTdd();
    this.random = new Random();
    this.index = random.nextInt(products.length);
  }

  @Test
  public void shouldAcceptPennies() throws Exception {
    mockMvc.perform(post("/insertCoin").param("coin","1")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.status",equalTo(true)));
  }

  @Test
  public void shouldAcceptNickels() throws Exception {
    mockMvc.perform(post("/insertCoin").param("coin", "5")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.status", equalTo(true)));
  }

  @Test
  public void shouldAcceptDimes() throws Exception {
    mockMvc.perform(post("/insertCoin").param("coin", "10")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.status", equalTo(true)));
  }

  @Test
  public void shouldAcceptQuarters() throws Exception {
    mockMvc.perform(post("/insertCoin").param("coin", "25")
    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.status", equalTo( true)));
  }

  @Test
  public void shouldAcceptOneDollarBills() throws Exception {
    mockMvc.perform(post("/insertNote").param("note", "1")
    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.status", equalTo(true)));
  }

  @Test
  public void shouldAcceptTwoDollarBills() throws Exception {
    mockMvc.perform(post("/insertNote").param("note", "2")
    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.status", equalTo(true)));
  }

  @Test
  public void shouldAllowUserToSelectProduct() throws Exception {

    mockMvc.perform(post("/selectProduct").param("product", String.valueOf(products[index]))
    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
    .andExpect(jsonPath("$.status", equalTo(true)));
  }


  @Test
  public void shouldAllowUserToReceiveRefund() throws Exception {
    mockMvc.perform(post("/addProduct").param("product", Products.CANDY.toString())
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.status", equalTo(true)));

    mockMvc.perform(post("/addProduct").param("product", Products.Soda.toString())
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.status", equalTo(true)));

    mockMvc.perform(post("/refundProducts")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.price", equalTo(Products.CANDY.getPrice()+Products.Soda.getPrice())));
  }

  @Test
  public void shouldGiveProductAndGiveChangeIfAnyUponPurchase() throws Exception {
    mockMvc.perform(post("/completeTransaction")
        .param("product", Products.CANDY.toString(),  Products.NUTS.toString() , Products.SNACK.toString())
        .param("money","160")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.price", equalTo(10)));
  }



}