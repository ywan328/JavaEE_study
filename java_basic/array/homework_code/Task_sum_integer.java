package com.kkb.task;

public class Task_sum_integer {
    public static void main(String[] args) {
        int num2 = 54321;
        int num2G = ge(num2); //获得个位数
        int num2S = shi(num2); //获得十位数
        int num2B = bai(num2); //获得百位数
        int num2Q = qian(num2); //获得千位数
        int num2W = wan(num2); //获得万位数
        int num2Sum = num2G+num2S+num2B+num2Q+num2W;
        System.out.println("各位数字之和是:"+num2Sum);
    }
    public static int ge(int num) {
        int a = num % 10; //取出num的个位数
        return a;
    }
    public static int shi(int num) {
        int a = num % 100/10; //取出num的个位数
        return a;
    }
    public static int bai(int num) {
        int a = num % 1000/100; //取出num的个位数
        return a;
    }
    public static int qian(int num) {
        int a = num % 10000/1000; //取出num的个位数
        return a;
    }
    public static int wan(int num) {
        int a = num % 100000/10000; //取出num的个位数
        return a;
    }
}
