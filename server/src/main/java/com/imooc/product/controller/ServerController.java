package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * liangbingtian 2019/3/8 上午10:54
 */
@RestController
public class ServerController {

  @GetMapping("/getMessage")
  public String getProduct(){

    return "this is a product";
  }

}
