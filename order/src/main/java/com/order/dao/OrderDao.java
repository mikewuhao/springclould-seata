package com.order.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-07 20:47
 * @Description: OrderService
 * @Version: 1.0
 **/
@Repository
public class OrderDao {
    public String hello(String name) {
        return " 你好 ："+name;
    }
}