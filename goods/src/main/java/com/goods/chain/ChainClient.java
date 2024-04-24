package com.goods.chain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 23:43
 * @Description: ChainClient
 * @Version: 1.0
 **/
@Slf4j
@Component
public class ChainClient {

    @Autowired
    private List<AbstractChain<GoodsDto>> chainList;

    public boolean handleChain(GoodsDto dto) {
        boolean result = true;
        for (AbstractChain<GoodsDto> chain : chainList){
            if(BooleanUtils.isFalse(chain.test(dto))){
                result = false;
                break;
            }
        }
        return result;
    }
}