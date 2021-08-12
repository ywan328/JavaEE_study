package com.kkb.task;

public class Task_variable_exchange {
    public static  void main(String[] args) {
        int a = 30;
        int b = 60;

        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a);
        System.out.println(b);
    }
}
