package com.order.controller;

import com.order.client.GoodsFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

	@Resource
	GoodsFeignClient goodsFeignClient;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello,my name is order";
	}

	@RequestMapping("/query")
	public String query() {
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


	@RequestMapping("/pay")
	public String pay() {
		log.info("准备下单------");
		log.info(goodsFeignClient.reduce());
		return "pay finish";
	}


}
