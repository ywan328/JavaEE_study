package com.kkb.task;
import java.util.Scanner;

/**
 * 计算该年该月天数一年中有 12 个月， 而每个月的天数是不一样的。 其中大月 31 天， 分别为
 * 1,3,5,7,8,10,12 月， 小月 30 天， 分别 为 4,6,9,11 月。 还有二月比较特殊， 平年的二月只有 28 天，
 * 而闰年的二月有 29 天， 由用户在控制台输入年份和月份，程序计算该年该月的天数。
 * switch判断月份
 * 1月 3月 5月 7月 8月 10月 12月   都有31天
 * 4月 6月 9月 11月 都有30天
 * 2月  判断平年闰年
 * 平28天  闰29天
 */
public class Task_countDayPerMonth {
    public static void main(String[] args){
        boolean proceed = true;
        while(proceed) {
            int year = 2000;
            int month = 1;
            System.out.println("请输入年份：");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {//检查必须输入整数
                year = input.nextInt();
            } else {
                System.out.println("输入有误，请输入整数！");
            }
            System.out.println("请输入月份：");
            if (input.hasNextInt()) {//检查必须输入整数
                month = input.nextInt();
                if(month<1||month>12) {
                    System.out.println("输入有误，请输入1~12的整数");
                }
            } else {
                System.out.println("输入有误，请输入整数！");
            }
            //switch判断天数
            switch(month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("本月有31天");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("本月有30天");
                    break;
                case 2:
                    if(year%4==0&&year%100!=0||year%400==0) {
                        System.out.println("本月有29天");
                    }
                    else
                        System.out.println("本月有28天");
                    break;
            }
            System.out.println("是否继续？(是|否)");
            String choose = input.next();//取得用户输入
            if (choose.equals("是")) {
                proceed = true;
            }
            else if(choose.equals("否")) {
                proceed = false;
            }
            else {
                //退出程序
                System.out.println("输入有误，请输入“是”或者“否”！！！");
            }
        }
    }
}
