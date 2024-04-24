package com.goods.test;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-11-18 12:16
 * @Description: MyTest
 * @Version: 1.0
 **/
public class ReactiveStreamTest {
    public static void main(String[] args) {
        AtomicBoolean res = new AtomicBoolean(true);
        //1创建发布者
        //Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5)).subscribe(MySubscriber.create());
        //Flux.just(1,2,3,4).concatWith(Flux.just(5,6,7)).subscribe(MySubscriber.create());
        Flux<Integer> flux= Flux.create(sink -> {
                for(int i=10;i<20;i++){
                    if(i == 19){
                        throw new RuntimeException("19 异常！！！");
                    }
                    sink.next(i);
                }
            sink.complete();
        });
        flux
                .filter(x->x%2==0)
                .map(x-> x/0)
                .onErrorReturn(0)
                .subscribe(MySubscriber.create());

        System.err.println("操作结果是---res： "+res);
    }
}