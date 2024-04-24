import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

public class Test10 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        executor.submit(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.err.println("===奇数===》"+i);
            }
        });
        executor.submit(() -> {
            for (int i = 0; i < 10; i += 2) {
                System.err.println("===偶数===》"+i);
            }
        });
        System.out.println("====执行完成======");

    }

}