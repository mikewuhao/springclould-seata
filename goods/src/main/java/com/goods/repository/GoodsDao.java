package com.goods.repository;

import com.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-06-17 13:02
 * @Description: GoodsDao
 * @Version: 1.0
 **/
@Repository
public interface GoodsDao extends JpaRepository <Goods, Long>, JpaSpecificationExecutor<Goods>, CrudRepository<Goods,Long> {
}