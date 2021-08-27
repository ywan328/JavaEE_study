package com.kkb.util;

import java.io.*;

/**
 * 文件读写的工具类,方法都推荐静态
 * @author Yan Wang
 * @version 1.0
 */
public class IOUtil {
    /**从指定文件中读取数据
     *
     */
    public static Object readFile(String fileName)throws IOException,ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    /**
     * 写入数据到指定文件
     *
     */
    public static void writeFile(Object obj,String fileName)throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
    }
}
