package com.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-03-18 10:46
 * @Description: JucTest
 * @Version: 1.0
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.err.println("rpc调用接口A，完成");
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.err.println("rpc调用接口B，完成");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.err.println("rpc调用接口C，完成");
            }
        });
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        Long endTime = System.currentTimeMillis();
        System.err.println("接口调用完成，耗时："+ (endTime-startTime)+"毫秒");
    }
}