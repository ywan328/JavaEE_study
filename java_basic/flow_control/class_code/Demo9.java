package com.kaikeba.demo1;

public class Demo9 {

	/**
	 * break��continue���
	 * 		break��������ֹ�������д�ѭ��������ִ�б���ѭ����break��������,ֱ������ѭ����
	 * 		continue��������ֹ���ֱ���ѭ����������ѭ����continue����Ĵ��벻ִ��,������һ��ѭ��������жϡ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			if(i==5) {
				continue;
			}
			System.out.println(i);
		}
	}

}
