package com.order.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

@Slf4j
/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-01-08 15:36
 * @Description: Test
 * @Version: 1.0
 **/
public class Test {
//    public static void main(String[] args) {
//        new Thread(()-> System.out.println("hello thread")).start();
//    }

    public void main(String[] args) throws Exception {
//        String host  = InetAddress.getLocalHost().getCanonicalHostName();
//        System.err.println("--->"+host);
//    }
        this.printLog(()->{
            System.out.println("hello");
            return null;
        });
    }

    private <T> void printLog(Callable<T> call) throws Exception {
        T t = call.call();
        log.info("---->"+ JSONObject.toJSONString(t));
    }
}