package com.kaikeba.demo2;

public class Demo7 {

	/**
	 * ����	:	û������
	 */
	public static void main(String[] args) {
		int num = new Math2().sum(100, 200);
		System.out.println(num);
	}
}

class Math2{
	
	int sum(int x,int y) {
		return x+y;
	}
}