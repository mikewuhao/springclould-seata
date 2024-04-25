package com.order.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "t_order")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//id自增
    private Long id;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_total_count")
    private Integer goodsTotalCount;

    @Column(name = "sku_number")
    private String skuNumber;

    @Column(name = "modify_time")
    private LocalDateTime modifyTime;


    @Column(name = "createTime")
    private LocalDateTime createTime;



}