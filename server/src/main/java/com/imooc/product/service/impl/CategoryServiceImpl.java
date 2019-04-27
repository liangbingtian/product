package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import com.imooc.product.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * liangbingtian 2019/3/6 下午3:54
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Override
  public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
    return productCategoryRepository.findByCategoryTypeIn(categoryTypes);
  }
}
