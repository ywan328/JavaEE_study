package com.kaikeba.demo2;
/**
 * class ����{
 * 	��Ա����;
 * 	��Ա����;
 * }
 * 
 * ������д�ڡ�java�ļ��У���
 * һ��.java�ļ��У� ���Դ���N���࣬ ����ֻ�ܴ���һ��public���ε��ࡣ
 * ��java�ļ����ļ����� ���� ��public���ε����� ��ȫһ�£�
 *
 */
public class Demo {

	public static void main(String[] args) {
		//��������ĸ�ʽ��
		//���� ������ = new ����();
		Person p = new Person();
		//�������Ը�ֵ
		//��ʽ��	������.������=ֵ;
		p.name = "����";
		p.age = 18;
		p.sex = '��';
		p.say();
		
		
		int s = p.sum(100, 200);
		System.out.println(s);
	}
}
/**
 * �������ͼֽ
 */
class Person{
	//���� - ����
	String name;
	int age;
	char sex;
	//���� - ��Ϊ
	/**
	 * �����ʽ��
	 * ����ֵ���� ��������(��ʽ�����б�){
	 * 	������
	 * 	return ����ֵ;
	 * }
	 * 
	 * ���ø�ʽ��
	 * ������.��������(ʵ�ʲ����б�);
	 */
	
	void say() {
		System.out.println("���ҽ��ܣ�����"+name+" , �ҵ����䣺"+age+"���ҵ��Ա�"+sex);
	}
	
	int sum(int x,int y) {
		int z = x+y;
		return z;
	}
	
	/*
	void xxx() {
		if(true) {
			return;
		}
		System.out.println("����");
	}
	*/
	
}