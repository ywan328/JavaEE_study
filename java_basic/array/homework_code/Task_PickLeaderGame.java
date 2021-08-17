package com.kkb.task;

import java.util.Scanner;

public class Task_PickLeaderGame {
    /**
     * 今天同学们相约一起爬山游玩， 为了更好的进行这场活动， 大家准备推举一个人作为出游的临时队长。 为了体现合理公平， 大家提出了一个比较有趣的规则。
     * 所有人围成一圈， 顺序排号。 从第一个人开始报数（从 1 到 3 报数） ，凡报到 3 的人退出圈子， 剩下的人继续报数， 最后留下的当选为队长。
     * 请你通过编写程序， 求出一组人中的队长是原来第几位同学。
     * @author Yan Wang
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入爬上的总人数： ");
        int count = input.nextInt();
        //把所有的人放入数组
        int[] stuArr = new int[count];
        //给每个人去编号
        for (int i =0; i < stuArr.length; i++){
            stuArr[i] = i+1;
        }
        //输出所有的人员
        for (int i = 0; i < stuArr.length; i++){
            System.out.print(stuArr[i]+"\t");
        }
        //开始游戏：从1-3，报数到3的人出局；最后只剩一个人；
        int left = count;
        int js=0;
        System.out.println("\n出局顺序： ");
        while(left>1){
            for (int i =0; i<stuArr.length; i++){
                if(stuArr[i]!=-1) {//没有出局的人才能报数
                    js++;
                }
                if(js==3) {//报数到3的人出局
                    System.out.print(stuArr[i] + "\t");
                    stuArr[i] = -1;//值为-1的时候表示出局
                    left--;//剩下的人减少一个
                    js = 0;
                }
            }
        }
        //输出队长
        System.out.println("\n最后选出的队长是： ");
        for (int  i = 0; i <  stuArr.length; i++){
            if(stuArr[i]!=-1){
                System.out.println(stuArr[i]);


            }
        }

    }
}
