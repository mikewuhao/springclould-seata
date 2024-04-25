package com.order.controller;

import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("/hello")
    public String hello() {
        return "this server is order server";
    }

    /**
     * 下订单：先扣减库存，再创建订单
     *
     * @return
     */
    @RequestMapping(value = "/add/order")
    public String addOrder() {
        return orderService.addOrder();
    }
}
