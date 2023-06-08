package com.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-02-13 22:15
 * @Description: Goods
 * @Version: 1.0
 **/
@Builder
@Data
@AllArgsConstructor
public class Goods {

    private String skuName;
    private String skuNimber;
    private String skuImg;

}