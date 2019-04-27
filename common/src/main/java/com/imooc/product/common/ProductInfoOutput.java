package com.imooc.product.common;

import java.math.BigDecimal;
import lombok.Data;

/**
 * liangbingtian 2019/4/27 下午11:49
 */
@Data
public class ProductInfoOutput {

  private String productId;

  private String productName;

  // 商品单价
  private BigDecimal productPrice;

  // 商品库存
  private Integer productStock;

  // 商品描述
  private String productDescription;

  // 小图
  private String productIcon;

  // 商品状态 0-正常，1-下架
  private Integer productStatus;

  // 类目编号
  private Integer categoryType;

}
