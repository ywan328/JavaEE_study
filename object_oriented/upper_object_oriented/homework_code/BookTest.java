package com.kkb.task.test;

import com.kkb.task.OO.Task_Book;

public class BookTest {
    public static void main(String[] args) {
        //创建对象并赋值
        Task_Book book = new Task_Book();
        book.setTitle("三国演义");
        book.setPageNum(30);
        //调用展示方法
        book.detail();
    }
}
