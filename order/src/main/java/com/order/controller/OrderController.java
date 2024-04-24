package com.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.order.client.GoodsFeignClient;
import com.order.dao.OrderDao;
import com.order.domain.Order;
import com.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
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
		return "Hello,my name is order";
	}

	@RequestMapping("/query")
	public String query(){
		System.err.println("query");
		return "order info list";
	}

	@RequestMapping("/limit")
	public String limit() {
		return "order info limit";
	}

	@RequestMapping("/sentinel")
	public String sentinel() {
		return "order info sentinel";
	}


	@RequestMapping("/test")
	public void test() throws Exception {
		orderService.test();
	}

	@RequestMapping("/pay")
	public String pay() {
		return orderService.pay();
	}
}
