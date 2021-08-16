package com.kkb.task;

public class Task_printGraphic {
    public static void main(String[] args){		System.out.println("-------三角形打印-------");
        for(int i =0;i<5;i++) {
            //i:0 1 2 3 4
            //j空格数 4 3 2 1 0
            for(int j=i+1;j<5;j++) {
                System.out.print(" ");
            }
            //k星号对应i*2+1
            for(int k = 0;k<i*2+1;k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------直角三角形打印-------");
        for(int i =0;i<5;i++) {
            for(int j =0;j<i+1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------倒立直角三角形打印-------");
        for(int i=5;i>0;i--) {
            for(int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

