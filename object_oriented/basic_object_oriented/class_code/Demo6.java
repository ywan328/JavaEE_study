package com.kaikeba.demo2;

public class Demo6 {

	public static void main(String[] args) {
		Person3 p = new Person3("����",18);
		p.say();
		
		Person3 p2 = new Person3("����");
		p2.say();
	}

}
class Person3{
	
	Person3(String name2,int age2){
		name = name2;
		age = age2;
	}
	
	Person3(String name2){
		name = name2;
	}
	
	String name;
	int age;
	
	void say() {
		System.out.println("���ҽ��ܣ� ������"+name+", ���䣺"+age);
	}
	
}