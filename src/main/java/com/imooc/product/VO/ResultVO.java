package com.imooc.product.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * liangbingtian 2019/3/6 下午4:01
 */
@Data
public class ResultVO<T> implements IResultVO{

  /**
   * 错误码
   */
  private Integer code;

  /**
   * 提示信息
   */
  private String message;

  /**
   * 具体内容
   */
  private T data;

  private ResultVO(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> ResultVO<T> genSuccessfulResult(T data){
    return new ResultVO<>(IResultVO.SUCCESS_CODE, IResultVO.SUCCESS_MSG, data);
  }

}
