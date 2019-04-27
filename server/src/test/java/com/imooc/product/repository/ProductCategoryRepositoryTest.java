package com.imooc.product.repository;

import static org.junit.Assert.*;

import com.imooc.product.dataobject.ProductCategory;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * liangbingtian 2019/3/6 上午10:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Test
  public void findByCategoryTypeIn() {

    List<ProductCategory> list =
        productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 12));
    Assert.assertTrue(list.size() > 0);
  }
}
