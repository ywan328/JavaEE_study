package com.kkb.util;

import java.io.*;
/**
 * 文件读写技术
        *
        */
public class IOUtil {
    /**
     * 从指定的文件中读取数据
     * Reader
     * InputStream
     */
    public static Object readFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);//指定文件
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();//读出数据
    }

    /**
     * 写入数据到指定文件
     * Writer
     * OutputStream
     */
    public static void writeFile(Object obj,String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);//指定文件
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);//写入数据obj
    }

}

