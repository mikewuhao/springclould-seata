package com.goods.controller;

import com.alibaba.fastjson.JSONObject;
import com.goods.domain.Goods;
import com.goods.repository.GoodsDao;
import com.wuhao.redis.config.RedisProperties;
import com.wuhao.redis.core.RedisUtils;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class GoodsController {

    @Resource
    GoodsDao goodsDao;

    @Resource
    RedisUtils redisUtils;

    @Resource
    RedisProperties redisProperties;


    @RequestMapping("/hello")
    public String hello() {
        return "Hello,my name is goods";
    }

//	@RequestMapping("/reduce/goods")
//	public String reduceGoods() {
//		log.info("扣减可乐1瓶，开始");
//		return "扣减可乐1瓶";
//	}

    @RequestMapping("/reduce/goods")
    public String reduceGoods() {
        System.out.println("order事务id---------------------->" + RootContext.getXID());
        Goods goods = goodsDao.findById(1L).get();
        log.info("可乐商品情况----》" + JSONObject.toJSONString(goods));
        goods.setGoodsStock(goods.getGoodsStock() - 10);
        goodsDao.save(goods);
        return "扣减可乐10瓶";
    }

    @RequestMapping("/test/redis")
    public String redis() {
        redisUtils.set("222", "hello world");
        return "test key finish";
    }

}
