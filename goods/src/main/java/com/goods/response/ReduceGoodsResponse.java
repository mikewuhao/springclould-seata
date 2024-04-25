package com.goods.response;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-24 16:23
 * @Description: 扣减商品 出参
 * @Version: 1.0
 **/
@Builder
@Data
public class ReduceGoodsResponse {

    /**
     * 出参 信息
     */
    private String msg;

    /**
     * 出参状态码:200成功
     */
    private Integer statusCode;

}