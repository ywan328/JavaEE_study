package com.kkb.task;

/**
 * 1.定义一个整数类型并赋值任意五位正整数作为初始值,判断它是不是五位
 * 五位回文数：个位与万位相同，十位与千位相同，例如：12321
 *
 * @ author Yan Wang
 */
public class Task_isPalindrome {
    public static void main(String[] args) {
        int num = 12321;
        int a = num/10000%10; //万位
        int b = num/1000%10;  //千位
        int c = num/100%10;   //百位
        int d = num/10%10;    //十位
        int e = num/1%10;     //个位

        boolean result=(a==e & b==d)?true:false;
        System.out.println(num+"是否是回文数:"+ result);
    }
}
