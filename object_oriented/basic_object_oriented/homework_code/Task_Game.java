package com.kkb.task.OO;

/**
 * 游戏类
 * 定义一个游戏类,包括游戏的属性包括:游戏名,类型,大小,星级,介绍等,可以调用方法输出游戏的介绍.
 * @author Yan Wang
 */
public class Task_Game {
    //属性
    private String name; //游戏名
    private String type; //类型
    private int size; //大小
    private int level; //星级
    private String desc; //介绍

    //全参数构造的方法
    public Task_Game(String name1,String type1, int size1, int level1, String desc1){
        name = name1;
        type = type1;
        size = size1;
        level = level1;
        desc = desc1;
    }
    //方法
    public void show() {
        System.out.println("游戏的名称: "+ name);
        System.out.println("游戏的类型: " + type);
        System.out.println("游戏的大小: " + size);
        System.out.println("游戏的星级: " + level);
        System.out.println("游戏的介绍: " + desc);
    }
}
