package com.order;

import io.seata.config.springcloud.EnableSeataSpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@EnableJpaRepositories
public class OrderApplication {
    public static void main(String[] args) {
        try{
            SpringApplication.run(OrderApplication.class, args);
            System.err.println("启动完成");
        }catch (Exception e){
            System.err.println("启动失败：---》"+e.getMessage());
        }
    }

}
