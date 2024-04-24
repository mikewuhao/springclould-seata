package com.order.service;

import com.alibaba.fastjson.JSONObject;
import com.order.client.GoodsFeignClient;
import com.order.dao.OrderDao;
import com.order.domain.Order;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-07 20:47
 * @Description: OrderService
 * @Version: 1.0
 **/
@Service
@Slf4j
public class OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    GoodsFeignClient goodsFeignClient;


    public String hello(){
        privateMock("这个是私有函数");
        String name = "吴昊";
        return "wuhao";
    }

    public String test() throws Exception {
        this.printLog(()->{
            System.out.println("hello");
            return "hello";
        });
        return "hello";
    }

    private <T> void printLog(Callable<T> call) throws Exception {
        T t = call.call();
        log.info("---->"+ JSONObject.toJSONString(t));
    }


    private void privateMock(String mock){
        System.err.println("----》"+mock);
    }

    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    public String pay() {

        System.out.println("order事务id---------------------->" + RootContext.getXID());

        log.info("--创建订单--开始--");
        Order order = new Order();
        order.setOrderNo("20230617");
        order.setGoodsTotalCount(10);
        order.setGoodsName("可乐");
        order.setSkuNumber("33220011");
        orderDao.save(order);
        try{
            log.info("--商品减库存--开始--");
            String res = goodsFeignClient.reduce();
            log.info("--商品减库存--结束--》"+res);
        }catch (Exception e){
            log.error("商品减库存失败!!!");
            throw new RuntimeException("商品减库存失败！",e);
        }
        int i = 10/0;
        log.info("--创建订单--完成--");
        System.err.println("order---->"+ JSONObject.toJSONString(order));

        return "pay finish";

    }
}