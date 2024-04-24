/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/
import java.util.concurrent.*;

public class Test1 {

    public static void main(String[] args) {
        // 定义线程池参数
        int corePoolSize = 5; // 核心线程数
        int maximumPoolSize = 10; // 最大线程数
        long keepAliveTime = 100L; // 空闲线程存活时间
        TimeUnit unit = TimeUnit.MILLISECONDS; // 时间单位
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100); // 阻塞队列
        ThreadFactory threadFactory = Executors.defaultThreadFactory(); // 线程工厂
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy(); // 拒绝策略

        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );

        // 提交打印奇数的任务到线程池
        threadPoolExecutor.submit(() -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd: " + i);
            }
        });

        // 提交打印偶数的任务到线程池
        threadPoolExecutor.submit(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
            }
        });

        // 关闭线程池，不再接受新任务
        threadPoolExecutor.shutdown();

        // 尝试等待所有任务完成，或者超时后退出
        try {
            if (!threadPoolExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPoolExecutor.shutdownNow(); // 如果超时，则强制关闭线程池
            }
        } catch (InterruptedException e) {
            threadPoolExecutor.shutdownNow(); // 捕获中断异常，也强制关闭线程池
            Thread.currentThread().interrupt(); // 保留中断状态
        }
    }
}