package com.imooc.product.repository;

import static org.junit.Assert.*;

import com.imooc.product.dataobject.ProductInfo;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * liangbingtian 2019/3/5 下午9:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

  @Autowired
  private ProductInfoRepository productInfoRepository;

  @Test
  public void findByProductStatus() {
    List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(1);
    Assert.assertTrue(productInfoList.size() > 0);
  }

  @Test
  public void findByProductIdIn() {
    List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
    Assert.assertTrue(productInfoList.size() > 0);
  }
}
