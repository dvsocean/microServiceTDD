package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendingMachineController {

  @PostMapping("/insertCoin")
  public MyResponse insertCoin(@RequestParam("coin") int coin) {
    return  VendingMachine.vendingMachine.insertCoin(coin);
  }

  @PostMapping("/insertNote")
  public MyResponse insertBill(@RequestParam("note") int note){
    return  VendingMachine.vendingMachine.insertBill(note);
  }

  @PostMapping("/selectProduct")
  public MyResponse selectProduct(@RequestParam("product") int product){
    return  VendingMachine.vendingMachine.selectProduct(product);
  }

  @PostMapping("/addProduct")
  public MyResponse addProduct(@RequestParam("product") Products product){
    return  VendingMachine.vendingMachine.addProduct(product);
  }

  @PostMapping("/refundProducts")
  public MyResponse giveRefund(){
    return VendingMachine.vendingMachine.cancelTransaction();
  }

  @PostMapping("/completeTransaction")
  public MyResponse completeTransaction(@RequestParam("product")List<Products> products, @RequestParam("money")Integer money){
    return VendingMachine.vendingMachine.completeTransaction(products, money);
  }

  @GetMapping("/resetMachine")
  public int resetMachine(){
    VendingMachine.vendingMachine.unplug();
    VendingMachine.vendingMachine.plugBackInAndResetSystem();
    return VendingMachine.vendingMachine.getVoltage();
  }

  @GetMapping("/restAssuredEndpoint")
  public String restEndpoint(){
    return "IT WORKS";
  }
}
