package com.servera.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author wangqian
 * @Date 2022/10/31 13:50
 */
@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/login")
    public String loginPage(){
        logger.info("login page");
        return "login";
    }

    @GetMapping("/index")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String index(){
        logger.info("index page");
        return "index";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String printAdmin(){
        System.out.println("hello admin");
        return "admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String printUser(){
        System.out.println("hello user");
        return "user";
    }

    /**
     * 找不到页面
     */
    @GetMapping("/404")
    public String notFoundPage(){
        return "/error/404";
    }

    /**
     * 未授权
     */
    @GetMapping("/403")
    public String accessError(){
        return "/error/403";
    }

    /**
     * 服务器错误
     */
    @GetMapping("/500")
    public String internalError(){
        return "/error/500";
    }
}