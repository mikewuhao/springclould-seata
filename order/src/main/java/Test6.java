/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

public class Test6 {
    public static void main(String[] args) {
        int[] arr = {0, 11, 22, 33, 44, 55, 66};
        int result = binarySearch(arr,55);
        System.out.println("---》"+result);
    }
    private static int binarySearch(int[] arr, int target){
        //左边界
        int left =0;
        //右边界
        int right =arr.length-1;
        while (left<=right){
            //中间值
            int middle = left+(right-left)/2;
            //找到目标
            if(arr[middle]==target){
                return middle;
            //在左边
            }else if(arr[middle] > target){
                right = middle-1;
                //在右边
            }else{
                left = middle+1;
            }
        }
        //没找到，返回-1
        return -1;
    }
}