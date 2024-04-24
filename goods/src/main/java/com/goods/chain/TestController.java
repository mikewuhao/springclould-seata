package com.goods.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 11:15
 * @Description: Test
 * @Version: 1.0
 **/
@Slf4j
@RestController
public class TestController {
    @Autowired
    private ChainClient chainClient;

    /**
     * 责任链测试
     * @return
     */
    @RequestMapping("/test/chain")
    public String testChain() {
        GoodsDto dto = GoodsDto.builder()
                .weight(100)
                .goodsName("macBookPro")
                .address("北京市朝阳区亮马桥汇佳大厦")
                .price(0L)
                .count(1)
                .discount(1)
                .build();
        boolean result = chainClient.handleChain(dto);
        log.info("责任链执行完成，校验结果：{}",result);
        return "hello";
    }
}