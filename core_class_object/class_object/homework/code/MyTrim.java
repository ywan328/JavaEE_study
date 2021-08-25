package com.kkb.task.ClassObject;

public class MyTrim {
    /**
     * 4.写一个和 trim 功能相同的方法
     * 思路：
     * 1.定义两个变量，用来存储两个角标
     * 2.分别从头和尾遍历字符串，直到找到第一个不为空格的字符
     * 3.截取字符串
     */
    public static void main(String[] args) {

        String s = "   aab cccccdd ddd   ";
        String s2 = trims(s);//传入s
        System.out.println("调用结果: "+s2);
    }
    /**
     * 实现一个类似trim的功能
     * @param s
     * @return 删除了空格的字符串
     */
    private static String trims(String s) {
        int first = 0;
        int last = s.length() - 1;
        while (first <= last && s.charAt(first) == ' ') {// charAt​() 返回指定索引处的 char值
            first++;
        }
        while (first <= last && s.charAt(last) == ' ') {
            last--;
        }

        return s.substring(first, last + 1);
    }
}

