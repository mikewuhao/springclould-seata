package com.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello,my name is order";
	}

}
