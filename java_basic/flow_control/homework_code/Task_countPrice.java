package com.kkb.task;

import java.util.Scanner;

/**
 * 商场根据会员积分打折：2000分以内打9折，4000分以内打8折，8000分以内打7.5折，8000分以上打7折，
 * 使用if-else-if结构，实现手动输入购物金额和积分，计算出应缴金额
 */
public class Task_countPrice {

    public static void main(String[] args){
        // TODO Auto-generated method  stub
        Scanner input = new Scanner(System.in);
        System.out.print("请输入购物金额：");
        double money= input.nextDouble();
        System.out.print("请输入积分： ");
        int score=input.nextInt();
        if(score<=2000){
            money = money*0.9;
        }else if(score<=4000){
            money = money*0.8;
        }else if(score<=8000){
            money = money*0.75;
        }else{
            money=money*0.7;
        }
        System.out.println("应缴金额是： "+money);

    }
}
