package com.servera.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/31 13:49
 */

@Configuration
public class ErrorPageConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        WebServerFactoryCustomizer<ConfigurableWebServerFactory> webCustomizer = new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory){
                ErrorPage[] errorPages = new ErrorPage[]{new ErrorPage(HttpStatus.FORBIDDEN, "/403"), new ErrorPage(HttpStatus.NOT_FOUND, "/404"), new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"),};
                factory.addErrorPages(errorPages);
            }
        };
        return webCustomizer;
    }
}