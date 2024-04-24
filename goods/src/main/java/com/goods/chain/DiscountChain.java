package com.goods.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 11:12
 * @Description: FirstChain
 * @Version: 1.0
 **/
@Slf4j
@Component
@Order(1)
public class DiscountChain extends AbstractChain<GoodsDto> {
    @Override
    public boolean validate(GoodsDto dto) {
        if(Objects.nonNull(dto.getDiscount()) && dto.getDiscount() <1){
            log.error("折扣小于1折，校验失败!");
            return false;
        }
        return true;
    }
}