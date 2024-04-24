package com.goods.chain;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-23 11:23
 * @Description: AbstractChain
 * @Version: 1.0
 **/
@Slf4j
public abstract class AbstractChain<T> implements Predicate<T> {

    public abstract boolean validate(T o);

    @Override
    public boolean test(T o) {
        if (validate(o)) {
            return true;
        } else {
            log.error("被规则类『" + this.getClass().getCanonicalName() + "』过滤住了！");
        }
        return false;
    }
}