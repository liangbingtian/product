package com.imooc.product.dto;

import lombok.Data;

/**
 * liangbingtian 2019/3/8 下午4:54
 */
@Data
public class CartDTO {

  /**
   * 商品id
   */
  private String productId;

  /**
   * 商品数量
   */
  private Integer productQuantity;

  public CartDTO() {
  }

  public CartDTO(String productId, Integer productQuantity) {
    this.productId = productId;
    this.productQuantity = productQuantity;
  }
}
