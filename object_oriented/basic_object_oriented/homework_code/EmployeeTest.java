package com.kkb.task.test;

import com.kkb.task.OO.Task_Employee;

public class EmployeeTest {
    public static void main(String[] args){
        //创建员工
        Task_Employee e = new Task_Employee("搬砖人","C0004",14000,0.2);
        //调用方法
        System.out.println(e.getName());
        System.out.println(e.getNumber());
        System.out.println(e.getBaseSalary());
        System.out.println(e.getRate());
        System.out.println(e.getSumSalary());
    }

}
