package com.kkb.task.test;

import com.kkb.task.OO.Task_MyList;

public class MyListTest {
    public static void main(String[] args) {
        Task_MyList list = new Task_MyList();

        //添加元素
        for (int i = 0; i < 5; i++){
            list.add("kkb"+i);
        }
        String s="test";
        list.add(s);
        //删除元素
        Object obj = list.remove(s);
        System.out.println("删除的元素: "+obj);
        //获取元素
        for (int i =0; i <list.getSize();i++){
            System.out.println(list.get(i));
        }
    }
}
