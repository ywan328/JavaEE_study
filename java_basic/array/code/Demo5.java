package com.kaikeba.demo1;

public class Demo5 {

	/**
	 * ���ֲ��ң��۰���ң�
	 */
	public static void main(String[] args) {
		int[] nums = {10,20,30,40,50,60,70,80,90};
		
		//Ҫ���ҵ�����
		int num = 20;
		
		//�ؼ�������������
		//1.	��С��Χ�±�
		int minIndex = 0;
		//2.	���Χ�±�
		int maxIndex = nums.length-1;
		//3.	�м������±�
		int centerIndex = (minIndex+maxIndex)/2;
		while(true) {
			System.out.println("ѭ����һ��");
			if(nums[centerIndex]>num) {
				//�м����ݽϴ�
				maxIndex = centerIndex-1;
			}else if(nums[centerIndex]<num) {
				//�м����ݽ�С
				minIndex = centerIndex+1;
			}else {
				//�ҵ�������  ����λ�ã�centerIndex
				break;
			}
			
			if(minIndex > maxIndex) {
				centerIndex = -1;
				break;
			}
			//���߽緢���仯�� ��Ҫ�����м��±�
			centerIndex = (minIndex+maxIndex)/2;
		}
		
		System.out.println("λ�ã�"+centerIndex);
		
	}
}
