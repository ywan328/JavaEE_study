package com.kaikeba.demo1;

public class Demo4 {

	/**
	 * ð������
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {20,15,18,13,30,60};
		int temp;
		//���ѭ�����Ƶ��ǣ� �Ƚϵ�������
		//���ѭ�������� length-1
		for(int i=0;i<nums.length-1;i++) {
			//�ڲ�ѭ�����Ƶ��ǣ�ÿ�ֱȽϵĴ���
			//��i�֣�i��0��ʼ���㣩�� �Ƚϴ���Ϊ��length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					//������ȣ� �����ƶ�����
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		
		//�����Ѿ���ɡ� �����Ǳ�����ӡ�鿴�Ĺ���
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
		
		
		
	}

}
