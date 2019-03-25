package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * liangbingtian 2019/3/6 上午10:44
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
