package com.kaikeba.demo2;

public class Demo2 {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		b1.name = "��ƻ��";
		b1.info = "�����˹�ũ��ֲ��ɫƻ��������·�̡�";
		b2.name = "��ƻ��";
		b2.info = "�����˹�ũ��ֲ��ɫƻ��������·�̡�";
		
		b1.say();
		b2.say();
		
	}

}
/*
class Book{
	String name;
	String info;
	
	void say() {
		System.out.println("������"+name+" , ��飺"+info);
	}
}
*/