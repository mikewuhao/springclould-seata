//package com.order.config;
//
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import io.seata.common.util.StringUtils;
//import io.seata.core.context.RootContext;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Copyright 2022 skyworth
// *
// * @Author: wuhao
// * @CreateTime: 2023-06-22 10:46
// * @Description: FeignConfig
// * @Version: 1.0
// **/
//@Configuration
//public class FeignConfig implements RequestInterceptor {
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        String xid = RootContext.getXID();
//        if (StringUtils.isNotEmpty(xid)) {
//            requestTemplate.header(RootContext.KEY_XID, xid);
//        }
//    }
//}