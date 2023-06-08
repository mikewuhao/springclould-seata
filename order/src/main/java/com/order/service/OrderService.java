package com.order.service;

import com.order.dao.OrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-07 20:47
 * @Description: OrderService
 * @Version: 1.0
 **/
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    public String hello(){
        privateMock("这个是私有函数");
        String name = "吴昊";
        return orderDao.hello(name);
    }

    private void privateMock(String mock){
        System.err.println("----》"+mock);
    }
}