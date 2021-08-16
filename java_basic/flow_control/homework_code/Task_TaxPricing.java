package com.kkb.task;

import java.util.Scanner;
/**
 * 出租车计费训练任务
 * @auther Yan Wang
 */
public class Task_TaxPricing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0; //总费用
        double perPrice = 2.3; //基本单价
        double mileMoney = 0; //里程费用
        double lowSpeedMoney = 0; //低速行驶费用
        double orderMoney = 0; //预约叫车费用
        double emptyMoney = 0; //空驶费用
        double nightMoney = 0; // 夜间行驶费用
        double oilMoney = 1; //

        //----里程费用
        System.out.print("请输入总里程数：");
        double mile = input.nextDouble();
        if(mile>3) {
            mileMoney = 13+(mile-3)*perPrice;
        }else {
            mileMoney=13;
        }

        //----低速行驶费用
        System.out.println("是否有低速行驶（true/false)?");
        boolean lowSpeedFlag = input.nextBoolean();
        if(lowSpeedFlag){
            System.out.println("请输入低速行驶的时间：");
            int minute = input.nextInt();
            System.out.println("是否是在早晚高峰（true/false)：");
            Boolean rushFlag=input.nextBoolean();
            if(rushFlag){
                lowSpeedMoney=minute/5*perPrice*2;
            }else{
                lowSpeedMoney=minute/5*perPrice*1;
            }
        }

        //----预约交车的费用
        System.out.println("是否预约叫车（true/false)?");
        boolean orderFlag = input.nextBoolean();
        if(orderFlag){
            System.out.println("请输入预定的小时数：");
            int hour=input.nextInt();
            if(hour>4){
                orderMoney = 6;
            }else
                orderMoney = 5;
        }

        //----空驶费用
        if(mile>15){
            System.out.println("请输入是否往返在2公里范围内（true/false)?");
            boolean roundFlag = input.nextBoolean();
            if(!roundFlag){
                emptyMoney=(mile-15)*perPrice*1.5;
            }
        }


        //----夜间费用
        System.out.println("请输入是否夜间行驶true/false: ");
        boolean nightFlag = input.nextBoolean();
        if(nightFlag){
            nightMoney = (mile-3)*perPrice*0.2;

        }

        //计算总费用
        sum = mileMoney + lowSpeedMoney + orderMoney+ emptyMoney + nightMoney + oilMoney;
        //打印各种费用
        System.out.println("此次行程的总费用: "+Math.round(sum));
        System.out.println("里程费用: "+Math.round(mileMoney));
        System.out.println("低速行驶费用: "+Math.round(lowSpeedMoney));
        System.out.println("预约叫车费用: "+Math.round(orderMoney));
        System.out.println("空驶费用: "+Math.round(emptyMoney));
        System.out.println("夜间行驶费用: "+Math.round(nightMoney));
        System.out.println("燃油附件费用: "+Math.round(oilMoney));
    }
}
