package com.kaikeba.demo2;

/**
 * ���󴴽����ڴ�ϸ��
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.name = "��ƻ��";
		b1.info = "�����˹�ũ������ֲ��ƻ���Ĺ��̡�";
		
		Book b2 = new Book();
		b2.name = "��ƻ��";
		b2.info = "�����˹�ũ������ֲ��ƻ���Ĺ��̡�";
		
		b2 = b1;
		b2.name = "ͭƻ��";
		b1.say();
	}

}

class Book{
	String name;
	String info;
	
	void say() {
		System.out.println("������"+name+" , ��飺"+info);
	}
}


