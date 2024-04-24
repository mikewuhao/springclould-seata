package com.goods.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-17 12:58
 * @Description: Goods
 * @Version: 1.0
 **/
@Builder
@Data
@Entity
@Table(name = "t_goods")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//id自增
    private Long id;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_price")
    private Integer goodsPrice;

    @Column(name = "goods_type")
    private String goodsType;

    @Column(name = "goods_stock")
    private Integer goodsStock;

    @Column(name = "sku_number")
    private String skuNumber;



}