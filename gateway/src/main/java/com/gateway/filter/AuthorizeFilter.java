//package com.gateway.filter;
//
//import com.alibaba.fastjson.JSONObject;
//import com.gateway.config.WhiteListConfig;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import javax.annotation.Resource;
//
///**
// * @Author: wuhao
// * @CreateTime: 2022-12-09 15:16
// * @Description: 全局的权限验证过滤器
// * @Version: 1.0
// **/
//@Component
//public class AuthorizeFilter implements GlobalFilter, Ordered {
//
//    @Resource
//    private WhiteListConfig whiteListConfig;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // 1.获取请求参数
//        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
//        // 2.获取authorization参数
//        String auth = params.getFirst("authorization");
//
//        ServerHttpRequest request = exchange.getRequest();
//        String path = request.getPath().toString();
//
//        System.err.println("白名单列表-----》" + JSONObject.toJSONString(whiteListConfig.getUri()));
//        System.err.println("path-----》" + path);
//        System.err.println("命中白名单---》" + whiteListConfig.isCanAccess(path));
//
//        // TODO 是否命中白名单
//        if (whiteListConfig.isCanAccess(path)) {
//            return chain.filter(exchange);
//        }
//
//        // 3.校验
//        if ("1234".equals(auth)) {
//            // 放行
//            return chain.filter(exchange);
//        }
//        // 4.拦截
//        // 4.1.禁止访问，设置状态码
//        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//        // 4.2.结束处理
//        return exchange.getResponse().setComplete();
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}