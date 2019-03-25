package com.imooc.product.service;

import static org.junit.Assert.*;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductCategory;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * liangbingtian 2019/3/6 下午3:58
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests {

  @Autowired
  private CategoryService categoryService;

  @Test
  public void findByCategoryTypeIn() {
    List<ProductCategory> productCategoryList =
        categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
    Assert.assertTrue(productCategoryList.size() > 0);
  }
}
