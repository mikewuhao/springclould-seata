package com.gateway.test;

import reactor.core.publisher.Flux;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-07-17 23:09
 * @Description: Test
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Flux<String> data = Flux.just("hello", "hello2");//1
        data = data.map(e -> e + " world"); //2
        data.subscribe( e ->  System.out.println(e) );//3
    }
}