package com.imooc.product.client;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * liangbingtian 2019/4/29 下午6:57
 */
@FeignClient(name = "product")
public interface ProductClient {

  /**
   * 获取订单所需要的商品list
   */
  @PostMapping("/product/listForOrder")
  List<ProductInfoOutput> listForOrder(@RequestBody List<String> productInfoOutputlist);

  @PostMapping("/product/decreaseStock")
  void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
