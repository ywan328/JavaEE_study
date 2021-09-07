package day03_Demo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLDemo1 {
	//https://qd.myapp.com/myapp/qqteam/pcqq/PCQQ2020.exe
	public static void main(String[] args) throws Exception{
		System.out.println("��ӭʹ�� ��ְ�� �ļ�������");
		System.out.println("������Ҫ���ص��ļ���ַ��");
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		//1.	����һ��URL����
		URL url = new URL(text);
		//2.	��ȡ�ļ�����
		String name = url.getFile();///myapp/qqteam/pcqq/PCQQ2020.exe
		name = name.substring(name.lastIndexOf("/")+1);
		//3.	ͨ��url �� ������
		URLConnection conn = url.openConnection();
		//4.	ͨ�����Ӷ��� ��ȡ�ļ��ܳ���  �ֽ���
		long length = conn.getContentLengthLong();
		//5.	ͨ�����Ӷ��� ��ȡ��Դ��������
		InputStream is = conn.getInputStream();
		//6.	����һ���ļ������ �� ���ڱ������ص�����
		File file = new File("C:\\Users\\cdd\\Desktop\\"+name);
		FileOutputStream fos = new FileOutputStream(file);
		
		int len = -1;
		byte[] bytes = new byte[1024*1024];
		int sum = 0;
		while(true) {
			len = is.read(bytes);
			if(len == -1) {
				break;
			}
			fos.write(bytes, 0, len);
			sum+=len;
			System.out.println("�������أ�"+sum/(length/100)+"%");
		}
		is.close();
		fos.close();
		
		/*
		while(true) {
			int b = is.read();
			if(b==-1) {
				break;
			}
			fos.write(b);
			System.out.println("������һ���ֽ�");
		}
		*/
		System.out.println("�������");
		
		
	}

}
