//package com.order.interceptor;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import io.seata.core.context.RootContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//
///**
// * Copyright 2022 skyworth
// *
// * @Author: wuhao
// * @CreateTime: 2023-06-22 10:29
// * @Description: MultipartSupportConfig
// * @Version: 1.0
// **/
//public class MultipartSupportConfig implements RequestInterceptor {
//
//    @Override
//    public void apply(RequestTemplate template) {
//        //解决不传递请求头中的token
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes != null) {
//            HttpServletRequest request = attributes.getRequest();
//            Enumeration<String> headerNames = request.getHeaderNames();
//            //可以在这里将自定义请求头传递进去， key 请求， value 值
//            //处理上游请求头信息，传递时继续携带
//            while (headerNames.hasMoreElements()) {
//                String name = headerNames.nextElement();
//                String values = request.getHeader(name);
//                template.header(name, values);
//            }
//        }
//
//        // 解决seata的xid未传递
//        String xid = RootContext.getXID();
//        template.header(RootContext.KEY_XID, xid);
//    }
//}