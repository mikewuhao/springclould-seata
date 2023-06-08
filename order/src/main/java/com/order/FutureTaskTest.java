package com.order;

import com.sun.xml.internal.ws.util.CompletedFuture;
import io.netty.util.concurrent.CompleteFuture;

import java.util.concurrent.*;

/**
* Copyright 2022 skyworth
*@Author: wuhao
*@CreateTime:  2023-03-18 11:16
*@Description: FutureTaskTest
*@Version: 1.0
**/
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        FutureTask<String> futureTask1 = new FutureTask<>(task1);
        FutureTask<String> futureTask2 = new FutureTask<>(task2);
        FutureTask<String> futureTask3 = new FutureTask<>(task3);
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        executorService.submit(futureTask3);
        String str1 = futureTask1.get();  // get result
        String str2 = futureTask2.get();  // get result
        String str3 = futureTask3.get();  // get result
        System.err.println(str1 + str2 + str3);
        Long endTime = System.currentTimeMillis();
        System.err.println("接口调用完成，耗时：" + (endTime - startTime) + "毫秒");
    }
}

class Task1 implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "rpc调用接口A，完成";
    }
}


class Task2 implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "rpc调用接口B，完成";
    }
}

class Task3 implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "rpc调用接口c，完成";
    }
}
