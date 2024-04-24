/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

public class Test12 {
    public static void main(String[] args) {
        int num = 889988;
        boolean flag = isPalindrome(num);
        System.err.println("是否是回文数===》"+flag);
    }


    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int left = 0;
        int right = str.length()-1;
        while (left <= right) {
            if(str.charAt(left) !=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}