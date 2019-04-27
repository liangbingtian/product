package com.imooc.product.enums;

import lombok.Getter;

/**
 * liangbingtian 2019/3/6 上午11:08
 */
@Getter
public enum ProductStatusEnum {

  UP(0, "在架"), DOWN(1, "下架"),;

  private Integer code;

  private String message;

  ProductStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
