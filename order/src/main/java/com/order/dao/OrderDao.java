package com.order.dao;

import com.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-07 20:47
 * @Description: OrderService
 * @Version: 1.0
 **/
@Repository
public interface OrderDao extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>, CrudRepository<Order,Long> {
}