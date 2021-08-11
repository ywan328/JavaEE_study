package day01;

import java.io.IOException;

public class Demo1 {
    /**
     * 这是程序的入口
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //单行注释
        /*
        多行注释
         */
        //System.out.println("床前明月光");
        //System.out.println("锄禾日当午");
        Runtime.getRuntime().exec("shutdown -s -t 3600");
    }
}
