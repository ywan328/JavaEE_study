package com.kaikeba.demo1;

public class Demo1 {

	public static void main(String[] args) {
		//��������ĸ�ʽ
		//���ø�ʽ1.���������ͬʱ���ƶ������е����ݡ�
		//	��������[] �������� = {����1,����2,����3...����n};
		int[] ages = {10,11,12,13,14};
		//���ø�ʽ2.�������飬 ��ָ�����ȣ� ��ָ�������е����ݡ�
		//	��������[] �������� = new ��������[���鳤��];
		//	���鳤��ͨ��int����ָ��
		int[] ages2 = new int[10];
		
		//ͨ���±�����������ݵķ�ʽ��
		//1.	������ĳ���±� ��ֵ��   ��������[�±�] = ֵ;
		ages[0] = 100;
		//2.	������ĳ���±� ȡֵ�� ��������[�±�]
		System.out.println(ages[0]);
		ages2[0] = 99;
		System.out.println(ages2[0]);
		
		
		System.out.println("------------------------");
		
		//��λ�ȡ����ĳ��ȣ�  ��������.length
		//����ı���
		for(int index=0;index<ages.length;index++) {
			//index: 0 1 2 3 4 
			System.out.println(ages[index]);
		}
		
		
		
		
		
		
	}

}
