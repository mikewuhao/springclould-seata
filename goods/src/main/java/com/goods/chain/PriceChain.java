package com.goods.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 11:14
 * @Description: ThirdChain
 * @Version: 1.0
 **/
@Slf4j
@Component
@Order(3)
public class PriceChain extends AbstractChain<GoodsDto> {
    @Override
    public boolean validate(GoodsDto dto) {
        if (Objects.isNull(dto.getPrice()) || dto.getPrice() < 1L) {
            log.error("商品定价不能为空或小于1分钱!");
            return false;
        }
        return true;
    }
}