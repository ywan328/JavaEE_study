package com.kkb.task;

import java.util.Scanner;
/**
 * 1、 查找某个整数
 * 定义一个长度为 10 的整型数组 nums ， 循环输入 10 个整数。
 * 然后将输入一个整数， 查找此整数， 找到输出下标， 没找到给出提示。
 */
public class Task_findInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] nums = new int[10];//存储整型数组
        int target = 0;//目标值
        boolean result = false;//是否找到目标值
        System.out.println("请依次输入10个整数的值：");
        for(int i =0; i<nums.length; i++) {
            // 接受用户输入之前要先判断输入类型，防止出错
            if (input.hasNextInt()) {
                nums[i] = input.nextInt();
            } else {
                System.out.println("输入有误，请输入整数！");
                System.exit(0);
            }
        }
        System.out.println("请输入要查找的整数的值：");
        if (input.hasNextInt()) {
            target = input.nextInt();
        } else {
            System.out.println("输入有误，请输入整数！");
        }
        for(int i =0; i<nums.length; i++) {
            if(nums[i]==target) {
                result = true;
                System.out.println("要找的整数下标为："+i);
            }
        }
        if(!result) {
            System.out.println("没有找到目标数");
        }
    }
}
