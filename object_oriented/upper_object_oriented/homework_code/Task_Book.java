package com.kkb.task.OO;

/**
 * 编写一个类 Book，代表图书:
 * 具有属性： 名称（title）、页数（pageNum），其中页数不能
 * 少于 200 页，否则输出错误信息，并赋予默认值 200。
 * 具有方法: 为各属性设置赋值和取值方法。 detail，用来在控制
 * 台输出每本图书的名称和页数
 * 编写测试类 BookTest 进行测试：为 Book 对象的属性赋予初始
 * 值，并调用 Book 对象的 detail 方法，看看输出是否正确
 *
 * @author Yan Wang
 */
public class Task_Book {
    //属性
    private String title; //名称
    private int pageNum; //页数

    //各属性设置赋值和取值方法
    public String getTitle(String title){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getPageNum(){
        return  pageNum;
    }
    public void setPageNum(int pageNum){
        if(pageNum<200){
            this.pageNum = 200;
            System.err.println("页面复制错误!不能小于200,已经赋值为默认值200!");
            return;
        }
        this.pageNum = pageNum;
    }
    //展示详细的方法
    public void detail(){
        System.out.println("图书名称是: "+title);
        System.out.println("图书页数是: "+pageNum);
    }

}
