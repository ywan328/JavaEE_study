package com.kkb.task.OO;

/**
 * 1.编写 Car类,属性有品牌(brand)和颜色(color),show 方法打印所有属性.
 * @author Yan Wang
 */
public class Task_Car {
    //属性
    private String brand; //品牌
    private String color; //颜色

    //无参构造方法
    public Task_Car(){

    }
    //全参构造方法
    public Task_Car(String b,String c){
        brand = b;
        color = c;
    }

    //方法
    public void show(){
        System.out.println("汽车品牌是: "+ brand);
        System.out.println("汽车颜色是: "+ color);
    }
}