package com.goods.test;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-11-18 12:41
 * @Description: MySubscriber
 * @Version: 1.0
 **/
@Slf4j
@Component
public class MySubscriber extends BaseSubscriber<Integer> {
    private AtomicInteger atomicInt = new AtomicInteger(0);

    private static ApplicationContext applicationContext;

    public static MySubscriber create (){
        log.info("-----create-----");
        /*AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        return beanFactory.createBean(MySubscriber.class);*/
        MySubscriber mySubscriber = new MySubscriber();
        return mySubscriber;
    }


    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        log.info("----hookOnSubscribe------");
        super.hookOnSubscribe(subscription);
    }

    @Override
    protected void hookOnNext(Integer num) {
        log.info("----hookOnNext------");
        /*if(num == 16){
            throw new IllegalArgumentException("16发生异常！！！");
        }*/
        Integer currentInt = atomicInt.incrementAndGet();
        System.err.println(Thread.currentThread().getName()+"currentInt---->"+currentInt);
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        log.info("----hookOnComplete------");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        log.info("----hookOnError------");
        log.error("发生异常：：：：：："+throwable.getMessage());
        super.hookOnError(throwable);
    }

    @Override
    protected void hookOnCancel() {
        log.info("----hookOnCancel------");
        super.hookOnCancel();
    }
}