package com.kkb.task.ClassObject.set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 已知数组存放一批 QQ 号码,长度 5-11 位，
 * String[] strs = {"10001","10086","12347806666","45612378901","10001","12347806666"}。
 * 将该数组里面的所有 qq 号都存放在 LinkedList 中，将 list 中重复元素删
 * 除，将 list 中所有元素分别用迭代器和增强 for 循环打印出来。
 */
public class RemoveRepeat {
    public static void main(String[] args) {
        String[] strs = {"10001", "10086", "12347806666", "45612378901", "10001", "12347806666"};
        LinkedList<String> list = getList(strs);
        //增强型for循环
        System.out.println("------增强型for循环------");
        for(String i : list){
            System.out.println(i);
        }
        //迭代器
        System.out.println("---------迭代器---------");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
    }

    public static LinkedList<String> getList(String[] strs){
        LinkedList<String> list = new LinkedList<String>();
        for(int i=0; i<strs.length; i++){
            if(list.contains(strs[i])){
                continue;
            }
            list.add(strs[i]);
        }
        return list;
    }
}

