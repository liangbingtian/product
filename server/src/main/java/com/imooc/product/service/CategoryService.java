package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;
import java.util.List;

/**
 * liangbingtian 2019/3/6 下午3:54
 * 类目管理的接口
 */
public interface CategoryService {

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

}
