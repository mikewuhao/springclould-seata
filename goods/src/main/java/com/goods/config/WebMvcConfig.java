package com.goods.config;

import com.goods.interceptor.SeataInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-22 10:57
 * @Description: 启动的时候添加一个拦截器 拦截针对的路径为：/**
 * @Version: 1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SeataInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}