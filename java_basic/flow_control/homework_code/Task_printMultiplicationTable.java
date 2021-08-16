package com.kkb.task;

public class Task_printMultiplicationTable {
    public static void main(String[] args){
        System.out.println("-------九九乘法表-------");
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"	");
            }
            System.out.println();
        }
    }
}