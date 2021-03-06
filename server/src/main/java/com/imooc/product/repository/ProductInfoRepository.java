package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * liangbingtian 2019/3/5 下午8:20
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

  List<ProductInfo> findByProductStatus(Integer productStatus);

  List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
