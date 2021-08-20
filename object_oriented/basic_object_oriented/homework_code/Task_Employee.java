package com.kkb.task.OO;

/**
 * 员工类注释:
 * 定义并测试一个代表员工的 Employee 类。它的属性包括“员工姓名”、
 * “员工号码”、“员工基本薪水”、“员工薪水增长率”；他的方法包括“构造方法”、“获
 * 取员工姓名”、“获取员工号码”、“获取员工基本薪水”、“计算薪水增长额”及“计
 * 算增长后的工资总额”。
 * @author Yan Wang
 */
public class Task_Employee {
    //属性
    private String name; //员工姓名
    private String number; //员工号码
    private double baseSalary; //员工基本薪水
    private double rate; //员工薪水增长率

    //构造方法
    public Task_Employee(){

    }
    public Task_Employee(String name1,String number1,double salary, double rate1){
        name = name1;
        number = number1;
        baseSalary = salary;
        rate = rate1;
    }
    //提供获取属性的方法
    public String getName(){
        return name;
    }
    /**
     * 获取员工的号码
     * @return
     */
    public String getNumber(){
        return number;
    }
    public double getBaseSalary(){
        return baseSalary;
    }

    public double getRate(){
        return baseSalary;
    }

    public double getSumSalary(){
        return baseSalary*(1+rate);
    }
}
