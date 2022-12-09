package com.gateway.controller;

import com.gateway.service.RedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    RedisTemplateService redisTemplateService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello,my name is gateway";
    }

    @RequestMapping("/test")
    public String test() {
        redisTemplateService.set("HELLO", "WORLD");
        return "test redis!";
    }
}
