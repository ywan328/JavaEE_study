package com.kaikeba.demo2;

public class Demo8 {

	/**
	 * ���һ������ �� ����׼��ʹ������ �� ���ϡ� ��ôһ��Ҫ������ ������������
	 * @param args
	 */
	public static void main(String[] args) {
		new Person5().name = "����";
		new Person5().age = 18;
		new Person5().say();
	}

}

class Person5{
	String name;
	int age;
	
	void say() {
		System.out.println("���ҽ��ܣ�������"+name+" �� ���䣺"+age);
	}
}