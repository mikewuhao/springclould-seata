/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

import java.util.concurrent.*;

public class Test2 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //奇数
        executor.submit(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("奇数---》" + i);
            }
        });
        //偶数
        executor.submit(() -> {
            for (int i = 2; i < 10; i += 2) {
                    System.out.println("偶数---》" + i);
            }
        });
    }
}