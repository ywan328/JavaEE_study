package com.kkb.task.OO;

/**
 * 试题：假设用户账号为：admin，密码为 123，编写用户登陆案例。 要
 * 求：请将登陆定义为 login 方法， 并将 login 方法写在 UserService 类中
 * @author Yan Wang
 */
public class Task_UserService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public boolean login(String userName, String password){
        //字符串比较相等的时候将常量放前面,防止空指针异常
        if("admin".equals(userName) &&"123".equals(password)){
            return true;
        }
        return false;
    }

}
