package com.kkb.task.OO;

/**
 * 通过类描述开课吧的 Java 学员。
 * 具有属性： 姓名，年龄，性别，爱好，公司（都是：开课吧），
 * 学科（都是：Java 学科）。
 * 思考：请结合 static 修饰属性进行更好的类设计。
 */
public class Task_Student {
    //	姓名， 年龄， 性别， 爱好， 公司（都是： 开课吧）， 学科（都是： Java 学科） 。
    private String name;
    private int age;
    private String gender;
    private String hobby;
    public static String company;
    public static String subject;

    //各属性设置赋值和取值方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public static String getCompany() {
        return company;
    }

    public static String getSubject() {
        return subject;
    }

    //方法
    public void show() {
        System.out.println("学生的名字: " + name);
        System.out.println("学生的年龄: " + age);
        System.out.println("学生的性别: " + gender);
        System.out.println("学生的爱好: " + hobby);
        System.out.println("学生的公司: " + company);
        System.out.println("学生的学科: " + subject);
    }
}
