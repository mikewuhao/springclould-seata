package com.goods.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 11:13
 * @Description: SecondChain
 * @Version: 1.0
 **/
@Slf4j
@Component
@Order(2)
public class AddressChain extends AbstractChain<GoodsDto> {
    @Override
    public boolean validate(GoodsDto dto) {
        if(StringUtils.isBlank(dto.getAddress())){
            log.error("收货地址不能为空！");
            return false;
        }
        return true;
    }
}