package com.goods.demo;

import com.goods.pojo.Goods;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-02-13 21:51
 * @Description: GuavaDemo
 * @Version: 1.0
 **/
@Slf4j
public class GuavaDemo {


    private static final LoadingCache<String, List<Goods>> goodsCache = CacheBuilder.newBuilder().maximumSize(100)
            .concurrencyLevel(8)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .removalListener(notification -> log.info("{} 缓存过期 was removed ", notification.getKey()))
            .build(new CacheLoader<String, List<Goods>>() {
                @Override
                public List<Goods> load(String skuNumber) {
                    log.info("初始化 开始 {}", skuNumber);
                    List<Goods> goods = null;
                    if (skuNumber.equals("001")) {
                        goods = Lists.newArrayList(new Goods("电脑", "001", "pcImg"), new Goods("手机", "001", "phoneImg"));
                    }
                    log.info("初始化 完成 {}", skuNumber);
                    return goods;
                }
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.err.println("------>" + goodsCache.get("001").toString());
        Thread.sleep(5000);
        System.err.println("------>" + goodsCache.get("002"));
    }

}
