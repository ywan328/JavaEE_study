package com.kkb.task.test;

import com.kkb.task.OO.Task_UserService;

import java.util.Scanner;

public class UserServiceTest {
    public static void main(String[] args) {
        Task_UserService userService = new Task_UserService();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名和密码: ");
        String userName = input.next();
        String password = input.next();
        boolean result = userService.login(userName, password);
        if(result) {
            System.out.println("登陆成功!");
        }else{
            System.out.println("登陆失败!用户名或密码错误!");
        }
    }
}
