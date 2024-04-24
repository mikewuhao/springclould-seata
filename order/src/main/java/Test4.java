import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

public class Test4 {

    public static void main(String[] args) {
        int[] arr = {1, 20, 5, 100, 10};
        System.out.println("排序前==》");
        for (int current :arr){
            System.out.println(current);
        }
        /*sort(arr);*/
        Arrays.sort(arr);
        System.out.println("排序后==》");
        for (int current :arr){
            System.out.println(current);
        }
    }

    private static void sort(int[] arr) {
        //外层是遍历次数
        for (int i = 0; i < arr.length; i++) {
            //内层是比较次数
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


}