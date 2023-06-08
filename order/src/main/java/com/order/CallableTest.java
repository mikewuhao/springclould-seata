package com.order;

import java.util.concurrent.*;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-03-18 11:00
 * @Description: CallableTest
 * @Version: 1.0
 **/
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableTask1 task1 = new CallableTask1();
        CallableTask2 task2 = new CallableTask2();
        CallableTask3 task3 = new CallableTask3();
        Future<String> res1 = executorService.submit(task1);
        Future<String> res2 = executorService.submit(task2);
        Future<String> res3 = executorService.submit(task3);
        String str1 = res1.get();  // get result
        String str2 = res2.get();  // get result
        String str3 = res3.get();  // get result
        System.err.println(str1 + str2 + str3);
        Long endTime = System.currentTimeMillis();
        System.err.println("接口调用完成，耗时：" + (endTime - startTime) + "毫秒");
    }
}




    class CallableTask1 implements Callable {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "rpc调用接口A，完成";
        }
    }

    class CallableTask2 implements Callable {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "rpc调用接口B，完成";
        }
    }

    class CallableTask3 implements Callable {
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "rpc调用接口B，完成";
        }
    }