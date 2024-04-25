package com.goods.controller;

import com.alibaba.fastjson.JSONObject;
import com.goods.domain.Goods;
import com.goods.repository.GoodsDao;
import com.goods.request.ReduceGoodsRequest;
import com.goods.response.ReduceGoodsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class GoodsController {

    @Resource
    GoodsDao goodsDao;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello,my name is goods";
    }

    /**
     * 扣减商品库存
     * @param request 商品对象
     * @return
     */
    @PostMapping(value = "/reduce/goods", produces = { "application/json;charset=utf-8" })
    @ResponseBody
    public ReduceGoodsResponse reduceGoods(@RequestBody ReduceGoodsRequest request) {
        log.info("request：{}", JSONObject.toJSONString(request));
        Goods goods = goodsDao.findById(request.getId()).get();
        goods.setGoodsStock(goods.getGoodsStock() - request.getReduceCount());
        goodsDao.save(goods);
        return ReduceGoodsResponse.builder().msg("商品扣减成功").statusCode(200).build();
    }

}
