package com.order.service;

import com.alibaba.fastjson.JSONObject;
import com.order.client.GoodsFeignClient;
import com.order.dao.OrderDao;
import com.order.domain.Order;
import com.order.request.ReduceGoodsRequest;
import com.order.response.ReduceGoodsResponse;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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

    /**
     * 下订单场景：先创建订单，再扣减库存，
     * @return
     */
    //@Transactional(rollbackFor = Exception.class)
    @GlobalTransactional
    public String addOrder() {
        log.info("创建订单,开始");
        Order order = new Order();
        order.setOrderNo("20230617");
        order.setGoodsTotalCount(10);
        order.setGoodsName("可乐");
        order.setSkuNumber("33220011");
        order.setModifyTime(LocalDateTime.now());
        order.setCreateTime(LocalDateTime.now());
        orderDao.save(order);
        log.info("创建订单,结束");

        ReduceGoodsRequest request = ReduceGoodsRequest.builder().reduceCount(10).id(1L).build();
        log.info("商品扣减库存，开始，rpc调用商品服务，入参：{}",JSONObject.toJSONString(request));
        ReduceGoodsResponse response = goodsFeignClient.reduce(request);
        log.info("商品扣减库存，完成，rpc调用商品服务，出参：{}",JSONObject.toJSONString(response));

        //mock异常，检查让分布式事务全回滚
        int i = 10/0;
        return "执行完成";
    }
}