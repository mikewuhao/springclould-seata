package com.goods.interceptor;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-22 10:52
 * @Description: MyInterceptor
 * @Version: 1.0
 **/
@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String xid = RootContext.getXID();
        String rpcXid = request.getHeader("TX_XID");
        log.info("xid in RootContext[{}] xid in HttpContext[{}]", xid, rpcXid);
        if (xid == null && rpcXid != null) {
            RootContext.bind(rpcXid);
            log.info("bind[{}] to RootContext", rpcXid);
        }
        return true;
    }
}