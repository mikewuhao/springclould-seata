/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-03-25 19:54
 * @Description: Test1
 * @Version: 1.0
 **/

public class Test7 {
    public static void main(String[] args) {
    int param =  102;
       boolean result = judg(param);
        System.out.println("===>"+result);
    }

    private static boolean judg(int param){
        if(param<0){
            return false;
        }
        String paramStr = String.valueOf(param);
        int left = 0;
        int right = paramStr.length()-1;
        while (left <= right){
            if(paramStr.charAt(left) != paramStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}