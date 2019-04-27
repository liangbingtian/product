package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * liangbingtian 2019/3/6 下午3:49
 */
@Component
public class ProductServiceTest extends ProductApplicationTests {

  @Autowired
  private ProductService productService;

  @Test
  public void findUpAll() {
    List<ProductInfo> productInfoList = productService.findUpAll();
    Assert.assertTrue(productInfoList.size() > 0);
  }

  @Test
  public void findList() {
    List<ProductInfo> productInfoList = productService.findList(Arrays.asList("157875196366160022","157875227953464068"));
    Assert.assertTrue(productInfoList.size() > 0);
  }

  @Test
  public void decreaseStock() {
    CartDTO cartDTO = new CartDTO("157875196366160022", 2);
    productService.decreaseStock(Arrays.asList(cartDTO));
  }
}
