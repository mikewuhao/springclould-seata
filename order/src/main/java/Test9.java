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

public class Test9 {
    public static void main(String[] args) {
        int[] arr = {11, 44, 22, 77, 33, 0};
        bubbleSort(arr);
        System.out.println("排序后===》"+ Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}