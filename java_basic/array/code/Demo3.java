package com.kaikeba.demo1;

public class Demo3 {

	//Ѱ�������е����ֵ | ��Сֵ
	public static void main(String[] args) {
		int[] nums = {10,30,40,33,22,20,11,0};
		//1.	����һ�������� ���ڴ洢��������ʱ���ֵ����ֵ
		int n = nums[0];
		//2.	ѭ��ȡ�������е�ÿһ�����ݣ� ��1��ʼ
		for(int i=1;i<nums.length;i++) {
			//�������е�ÿһ��������n�Ƚϣ� �����n�� ��n��ֵ��ֵΪ������ݡ�
			n = n<nums[i]?n:nums[i];
		}
		System.out.println(n);
	}

}
