package com.imooc.product.service.impl;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * liangbingtian 2019/3/6 上午11:06
 */
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductInfoRepository productInfoRepository;

  @Override
  public List<ProductInfo> findUpAll() {
    return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
  }

  @Override
  @Transactional
  public List<ProductInfoOutput> findList(List<String> productIdList) {
    return productInfoRepository
        .findByProductIdIn(productIdList)
        .stream().map(e -> {
          ProductInfoOutput output = new ProductInfoOutput();
          BeanUtils.copyProperties(e, output);
          return output;
        }).collect(Collectors.toList());

  }

  @Override
  public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
    for (DecreaseStockInput stockInput : decreaseStockInputList) {
      Optional<ProductInfo> productInfoOptional =
          productInfoRepository.findById(stockInput.getProductId());
      //判断商品是否存在
      if (!productInfoOptional.isPresent()) {
        throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
      }

      ProductInfo productInfo = productInfoOptional.get();
      //库存是否足够
      Integer result = productInfo.getProductStock() - stockInput.getProductQuantity();
      if (result < 0){
        throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
      }

      productInfo.setProductStock(result);
      productInfoRepository.save(productInfo);
    }
  }
}
