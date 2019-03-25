package com.imooc.product.controller;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.VO.ProductInfoVO;
import com.imooc.product.VO.ProductVO;
import com.imooc.product.VO.ResultVO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * liangbingtian 2019/3/5 下午7:28
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  /**
   * 1. 查询所有在架的商品 2. 获取类目type列表 3. 查询类目 4. 构造数据
   */
  @GetMapping("/list")
  public ResultVO list() {
    // 1 获取在架商品
    List<ProductInfo> productInfoList = productService.findUpAll();
    // 2 获取商品类目list
    List<Integer> categoryTypeList =
        productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
    // 3 从数据库中查询类目
    List<ProductCategory> productCategoryList =
        categoryService.findByCategoryTypeIn(categoryTypeList);
    // 4 构造数据
    List<ProductVO> productVOList = new ArrayList<>();
    for (ProductCategory productCategory : productCategoryList) {
      ProductVO productVO = new ProductVO();
      productVO.setCategoryName(productCategory.getCategoryName());
      productVO.setCategoryType(productCategory.getCategoryType());
      List<ProductInfoVO> productInfoVOList = new ArrayList<>();
      for (ProductInfo productInfo : productInfoList) {
        if (!productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
          continue;
        }
        ProductInfoVO productInfoVO = new ProductInfoVO();
        BeanUtils.copyProperties(productInfo, productInfoVO);
        productInfoVOList.add(productInfoVO);
      }
      productVO.setProductInfoVOList(productInfoVOList);
      productVOList.add(productVO);
    }
    return ResultVO.genSuccessfulResult(productVOList);
  }

  /**
   * 获取订单所需要的商品list
   */
  @PostMapping("/listForOrder")
  public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
    return productService.findList(productIdList);
  }

  @PostMapping("/decreaseStock")
  public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
    productService.decreaseStock(cartDTOList);
  }

}
