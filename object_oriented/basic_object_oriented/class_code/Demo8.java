package com.kaikeba.demo2;

public class Demo8 {

	/**
	 * 如果一个对象 ， 我们准备使用两次 或 以上。 那么一定要给对象 创建对象名。
	 * @param args
	 */
	public static void main(String[] args) {
		new Person5().name = "张三";
		new Person5().age = 18;
		new Person5().say();
	}

}

class Person5{
	String name;
	int age;
	
	void say() {
		System.out.println("自我介绍，姓名："+name+" ， 年龄："+age);
	}
}