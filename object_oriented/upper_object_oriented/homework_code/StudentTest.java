package com.kkb.task.test;

import com.kkb.task.OO.Task_Student;

public class StudentTest {
    public static void main(String[] args) {
        Task_Student stu1 = new Task_Student();
        stu1.setName("关羽");
        stu1.setAge(55);
        stu1.setGender("男");
        stu1.setHobby("打仗");
        //静态属性赋值:类名打点调用
        Task_Student.company = "开课吧";
        Task_Student.subject = "java学科";

        Task_Student stu2 = new Task_Student();
        stu2.setName("大乔");
        stu2.setAge(20);
        stu2.setGender("女");
        stu2.setHobby("弹琴");

        stu1.show();
        stu2.show();
    }
}
