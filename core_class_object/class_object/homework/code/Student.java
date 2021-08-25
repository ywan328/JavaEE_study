package com.kkb.task.ClassObject;

public class Student {

    private String name;
    private String age;
    private String classNum;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", classNum='" + classNum + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Student(String name, String age, String classNum) {
        this.name = name;
        this.age = age;
        this.classNum = classNum;
    }
}


