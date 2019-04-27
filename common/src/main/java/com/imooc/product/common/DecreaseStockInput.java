package com.imooc.product.common;

import lombok.Data;

/**
 * liangbingtian 2019/4/27 下午11:57
 */
@Data
public class DecreaseStockInput {


  /**
   * 商品id
   */
  private String productId;

  /**
   * 商品数量
   */
  private Integer productQuantity;


  public DecreaseStockInput() {
  }

  public DecreaseStockInput(String productId, Integer productQuantity) {
    this.productId = productId;
    this.productQuantity = productQuantity;
  }
}