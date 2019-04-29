package com.imooc.product.service;

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

}
