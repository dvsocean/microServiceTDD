package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MondayController {

  @PostMapping("/insertCoin")
  public MyResponse insertCoin(@RequestParam("coin") int coin) {
    return  MondayTdd.mondayTdd.insertCoin(coin);
  }

  @PostMapping("/insertNote")
  public MyResponse insertBill(@RequestParam("note") int note){
    return  MondayTdd.mondayTdd.insertBill(note);
  }

  @PostMapping("/selectProduct")
  public MyResponse selectProduct(@RequestParam("product") int product){
    return  MondayTdd.mondayTdd.selectProduct(product);
  }

  @PostMapping("/addProduct")
  public MyResponse addProduct(@RequestParam("product") Products product){
    return  MondayTdd.mondayTdd.addProduct(product);
  }

  @PostMapping("/refundProducts")
  public MyResponse giveRefund(){
    return MondayTdd.mondayTdd.cancelTransaction();
  }

  @PostMapping("/completeTransaction")
  public MyResponse completeTransaction(@RequestParam("product")List<Products> products,@RequestParam("money")Integer money){
    return MondayTdd.mondayTdd.completeTransaction(products, money);
  }
}
