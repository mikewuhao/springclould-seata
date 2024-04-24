package com.goods.chain;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 18:36
 * @Description: GoodsDTO 商品skuDTO
 * @Version: 1.0
 **/
@Data
@Builder
public class GoodsDto {

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格，单位分
     */
    private Long price;

    /**
     * 下单数量
     */
    private Integer count;

    /**
     * 重量，单位g
     */
    private Integer weight;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 折扣
     */
    private Integer discount;

}