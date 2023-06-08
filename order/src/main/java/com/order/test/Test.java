package com.order.test;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-01-08 15:36
 * @Description: Test
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("hello thread")).start();
    }

}