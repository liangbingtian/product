package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * liangbingtian 2019/3/10 上午10:41
 */
public class ProductException extends RuntimeException {

  private Integer code;

  private String message;

  public ProductException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public ProductException(ResultEnum resultEnum) {
    super(resultEnum.getMessage());
    this.code = resultEnum.getCode();
  }

}
