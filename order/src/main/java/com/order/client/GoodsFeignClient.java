package com.order.client;
import com.order.request.ReduceGoodsRequest;
import com.order.response.ReduceGoodsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-08 20:40
 * @Description: GoodsFeignClient
 * @Version: 1.0
 **/
@Component
@FeignClient(name = "goods")
public interface GoodsFeignClient {

    @PostMapping("/reduce/goods") //被调用接口的请求类型
    ReduceGoodsResponse reduce(@RequestBody ReduceGoodsRequest request);

}