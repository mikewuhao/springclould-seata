/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

public class Test11 {
    public static void main(String[] args) {
        int[] arr = {0,11,22,33,44,55,66,77,88};
        int target = 55;
        int index = binarySearch(arr,target);
        System.err.println("位置是---》"+index);

    }
    private static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int middle = left+(right-left)/2;
            if(arr[middle] == target){
                return middle;
            }else if(arr[middle] < target){
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return -1;
    }
}