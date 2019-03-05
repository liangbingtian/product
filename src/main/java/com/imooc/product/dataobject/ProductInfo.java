package com.imooc.product.dataobject;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * liangbingtian 2019/3/5 下午7:50 jpa中的下划线表名就不需要在类上加上@Table注解。因为会把下划线类名变成大写。即驼峰的形势
 */
@Data
@Entity
public class ProductInfo {

  @Id
  private String productId;

  private String productName;

  // 商品单价
  private BigDecimal productPrice;

  // 商品库存
  private String productStock;

  // 商品描述
  private String productDescription;

  // 小图
  private String productIcon;

  // 商品状态 0-正常，1-下架
  private Integer productStatus;

  // 类目编号
  private Integer categoryType;

  private Date createTime;

  private Date updateTime;

}
