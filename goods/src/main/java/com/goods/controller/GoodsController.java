package com.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello,my name is goods";
	}

}
