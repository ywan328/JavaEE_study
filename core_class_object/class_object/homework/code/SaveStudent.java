package com.kkb.task.ClassObject;

public class SaveStudent {
    /**
     * 2. String s="name=王五 age=18 classNum=1101";
     * 将上面的字符串中包含的信息存放到 Student（里面有 name，age，
     * classNum 三个属性）的对象中:
     * @param args
     */
    public static void main(String[] args) {
        String s="name=王五 age=18 classNum=1101";
        //将字符串分开
        Student stu = new Student();
        String[] arr = s.split(" ");
        /*for (int i = 0; i < arr.length; i++) {
            arr[i].substring(arr[i].indexOf("=")+1);
        }*/
        String[] s1 = arr[0].split("=");
        String[] s2 = arr[1].split("=");
        String[] s3 = arr[2].split("=");
        stu.setName(s1[1]);
        stu.setAge(s2[1]);
        stu.setClassNum(s3[1]);
        System.out.println(stu);
    }

}

