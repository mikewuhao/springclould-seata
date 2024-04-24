package com.goods.test;

import reactor.core.publisher.Mono;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-11-18 21:25
 * @Description: ReactorTest2
 * @Version: 1.0
 **/
public class ReactorTest2 {
    public static void main(String[] args) {
        // subscribe(Consumer<? super T> consumer,Consumer<? super Throwable> errorConsumer,
        // Runnable completeConsumer);  对正常元素和错误均有响应，还定义了序列正常完成后的回调
        Mono<String> data4 = Mono.just("4");
        Mono<Integer> integerMono2 = data4.flatMap((e) -> Mono.justOrEmpty(Integer.valueOf(e)));
        integerMono2.subscribe(
                (e)->{System.out.println(e);},
                (throwable)-> System.out.println("4-异常拉"+throwable.getMessage()),
                ()-> System.out.println("4-Mono 流执行正常"));
    }
}