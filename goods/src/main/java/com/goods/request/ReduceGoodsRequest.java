package com.goods.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-24 16:23
 * @Description: 扣减商品 入参
 * @Version: 1.0
 **/
@Builder
@Data
public class ReduceGoodsRequest {

    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品数量：单位瓶
     */
    private Integer reduceCount;

}