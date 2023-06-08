package com.goods.controller;

import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GoodsController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello,my name is goods";
	}

	@RequestMapping("/reduce/goods")
	public String reduceGoods() {
		log.info("扣减可乐1瓶，开始");
		return "扣减可乐1瓶";
	}

}
