package com.kkb.task;

/**
 *  打印三位数中的所有水仙花数
 * 	所谓“水仙花数” 即一个整数满足其值等于各个数位的立方和。
 * 	如: 153 是一个水仙花数， 因为 153= 1³+5³+3³
 */
public class Task_Print3DigitNarcissisticNumber {
    public static void main(String[] args){
        System.out.println("所有的三位数中的水仙花数如下：");
        for(int i=100;i<1000;i++) {//所有的三位数
            int hundreds=i/100;//百位
            int tens=(i%100)/10;//十位
            int ones=i%10;//个位
            if(i==(Math.pow(hundreds, 3)+Math.pow(tens, 3)+Math.pow(ones, 3))) {
                System.out.print(i+" ");
            }
        }
    }
}
