package com.kkb.task;

import java.util.Scanner;

public class Task_findMinOrMaxValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //定义数组
        int[] nums = new int[10];
        //给出数组元素循环赋值
        System.out.println("请输入10个整数： ");
        for (int i = 0; i<nums.length;i++){
            nums[i]=input.nextInt();
        }
        //定义最值的初值
        int max = nums[0];
        int min = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
            if(nums[i]<min){
                min = nums[i];
            }
        }
        System.out.println("最大值是： "+max);
        System.out.println("最小值是： "+min);
    }
}
