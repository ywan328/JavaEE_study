package com.kaikeba.demo2;

public class Demo4 {

	public static void main(String[] args) {
		//System.out.println("1");
		Person2 p1 = new Person2("����");
		//System.out.println("2");
		//p1.name  = "����";
		p1.age = 18;
		p1.say();
	}

}
class Person2{
	
	Person2(String n){
		name = n;
	}
	
	
	String name;
	int age;
	
	void say() {
		System.out.println("���ҽ��ܡ�����:"+name+" , �ҵ�����:"+age);
	}
}