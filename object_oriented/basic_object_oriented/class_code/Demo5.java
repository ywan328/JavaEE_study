package com.kaikeba.demo2;

public class Demo5 {

	public static void main(String[] args) {
		Math m = new Math();
		int num = m.sum(100, 500);
		System.out.println(num);
		
		double num2 = m.sum(10.5, 20.6);
		System.out.println(num2);
	}

}
// �����淶 ����֪��
class Math{
	/**
	 * һ�����ж���ķ����� ���������� ����ͬ�ķ������ƣ�
	 * 
	 * 1������������ͬ
	 * 2�������б���  �� �����б����� �� ����������˳��ͬ��
	 * 
	 * ע�⣺ �뷵��ֵ�����޹�
	 * 
	 */
	int sum(int x,int y) {
		int z = x+y;
		return z;
	}
	
	double sum(double x,double y) {
		double z = x+y;
		return z;
	}
	
	double sum(int x,double y) {
		double z = x+y;
		return z;
	}
	
	double sum(double y,int x) {
		double z = x+y;
		return z;
	}
	
}
