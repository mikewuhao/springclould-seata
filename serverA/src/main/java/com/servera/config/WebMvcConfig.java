package com.servera.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/31 13:48
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 配置静态资源
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}

