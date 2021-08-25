package com.kkb.task.ClassObject;

/**
 * 编写一个方法，将一段文本中的各个单词的字母顺序翻转，
 * 例如："I like writing code best"，将变成"I ekil gnitirw edoc tseb"。
 */
public class StringFunctionTest {

    public String myReverse(String str){
        //1.将每一个字符串按照空格分隔为数组, 字符串中split
        String[] arr = str.split(" ");
        //2.遍历字符串,将每一个单词反转 StringBuffer中reverse方法
        StringBuffer newStr = new StringBuffer();//新的字符串
        for (String s: arr){
            StringBuffer stringBuffer = new StringBuffer(s); //将字符串转换为StringBuffer
            stringBuffer.reverse(); //调用StringBuffer中reverse方法进行字符串的翻转
            newStr.append(stringBuffer).append(" "); //将翻转完的字符串拼接到新的字符串中
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        StringFunctionTest test = new StringFunctionTest();
        //测试一段文本中的各个单词的字母顺序翻转
        String  s= test.myReverse("I like writing code best");
        System.out.println(s);
    }
}
