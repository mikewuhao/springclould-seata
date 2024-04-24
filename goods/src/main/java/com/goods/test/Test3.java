package com.goods.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-11-18 21:25
 * @Description: test
 * @Version: 1.0
 **/
public class Test3 {
    public static void main(String[] args) {
        //TODO 定义线程池 默认阻塞策略
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(), null);
        //偶数
        executor.submit(() -> {
            for (int i = 0; i < 10; i += 2) {
                System.out.println("当前偶数是----》" + i);
            }
        });
        //奇数
        executor.submit(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("当前奇数是----》" + i);
            }
        });

    }
}
