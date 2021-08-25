package com.kkb.task.ClassObject;

import java.util.Scanner;

public class CompressString {
    /**
     * 3. 字符串压缩:利用字符重复出现的次数，编写一种方法，实现基本的字符
     * 串压缩功能。比如,字符串“aabccdd”会变成“a2b1c2d2”。若“压缩”以后的字
     * 符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文
     * 字母(a-z)
     * 示例 1：输入:aabcccccddddd
     * 输出:a2b1c5d5
     * 示例 2：输入：“abcdd” 输出:“abcdd” 解释:因为压缩后的字符串为:”a1b1c1d2”,长度大于原字符串
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串: ");
        String s1 = input.nextLine();
        String s2 = gets2(s1);
        String s3 = gets1(s1,s2);
        System.out.println(s3);
    }

    /**
     *
     * @param s1
     * @param s2
     * @return 短的字符串
     */
    private static String gets1(String s1,String s2){
        if (s1.length()<s2.length()){
            return s1;
        }else {
            return s2;
        }
    }

    /**
     *
     * @param ss
     * @return 压缩字符串
     */
    private static String gets2(String ss){
        StringBuffer sb = new StringBuffer();
        char[] arr = ss.toCharArray();//将此字符串转换为新的字符数组
        for(int i=0;i<arr.length-1;i++){
            int num = 1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    num++;
                }
            }
            int a = sb.indexOf(String.valueOf(arr[i]));
            if(a==-1){
                sb.append(arr[i]);
                sb.append(num);
            }
        }
        return sb.toString();
    }
}

