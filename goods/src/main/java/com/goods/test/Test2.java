package com.goods.test;

import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2023-11-18 21:25
 * @Description: test
 * @Version: 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {3,4,6,1,3,2,4};
        System.err.println("排序前===》"+ Arrays.toString(arr));
        //冒泡排序
        sort(arr);
        System.err.println("排序后===》"+ Arrays.toString(arr));
    }

    private static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
