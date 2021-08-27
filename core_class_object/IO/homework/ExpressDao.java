package com.kkb.dao;


import com.kkb.pojo.Express;
import com.kkb.util.IOUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 快递管理的dao-----对于所有快递的数据的操作(快递的录入,删除,修改,查看,返回可查看的快递柜)
 * @author Yan Wang
 * @version 1.0
 */
public class ExpressDao {
    //集合依然是模拟快递的柜子,假定模拟的是十行十列的柜子,总共是100个
    private List<Express> expressList = new ArrayList<>(100);
    private static final String FILE_NAME = "express.txt"; //整个项目的存储数据的文件名称

    static{
        System.out.println("ExpressDao静态代码块执行");
        File file = new File(FILE_NAME);
        if(!file.exists()){
            //如果文件不存在就创建一个
            try {
                if(file.createNewFile()){
                    System.out.println("第一次启动项目,创建存储文件成功!");
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());

            }
        }
    }

    public ExpressDao() {
        System.out.println("ExpressDao构造方法执行-----");
        //先初始化数据--从文件当中去读取数据
        try {
            Object obj = IOUtil.readFile(FILE_NAME);
            if(obj!=null && obj instanceof List){
                expressList = (List<Express>) obj;
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
//        expressList.add(new Express("S10001","顺丰",123456,0,0));
//        expressList.add(new Express("Y12341","圆通",523656,2,5));
//        expressList.add(new Express("Z10011","中通",323356,6,7));
    }

    /**
     * 根据取件码查询快递
     * @param code
     * @return
     */
    public Express findExpressByCode(int code){
        for(int i=0;i<expressList.size();i++){
            if(expressList.get(i).getCode()==code){
                return expressList.get(i);
            }
        }
        return null;
    }

    /**
     * 根据快递单号修改
     * @param number
     * @param expressNew
     * @return
     * @throws Exception
     */
    public boolean update(String number, Express expressNew) throws Exception {
        //先判断是否存在
        int index = findExpressByNumber(number);
        if(index==-1){
            throw new Exception("该快递不存在");
        }
        Express express = expressList.get(index);
        express.setCompany(expressNew.getCompany());
        express.setNumber(expressNew.getNumber());
        IOUtil.writeFile(expressList,FILE_NAME);
        return true;
    }

    /**
     * 删除指定的快递
     * @param express
     * @return
     */
    public boolean del(Express express) throws  IOException{
        boolean flag = expressList.remove(express);
        IOUtil.writeFile(expressList,FILE_NAME);
        return flag;
    }

    /**
     * 根据快递单号删除快递
     *
     * @param number
     * @return
     * @throws Exception
     */
    public boolean del(String number)throws Exception{
        //先判断是否存在
        int index = findExpressByNumber(number);
        if(index==-1){
            throw new Exception("该快递不存在");
        }
        expressList.remove(index);
        IOUtil.writeFile(expressList,FILE_NAME);
        return true;
    }

    /**
     * 根据单号查找快递
     * @param number
     * @return
     */
    public int findExpressByNumber(String number){
        for(int i=0;i<expressList.size();i++){
            if(expressList.get(i).getNumber().equals(number)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加一个快递
     * @param express
     * @return
     * @throws Exception
     */
    public Express add(Express  express)throws Exception{
        Random random =new Random();
        if(expressList.size()==100){
            throw new Exception("快递柜已满!不能放入快递了!");
        }
        int x,y;
        do{
            x = random.nextInt(10);
            y = random.nextInt(10);
        }while(isExist(x,y));//该位置有快递,重新生成坐标

        //系统产生随机的取件码100000-900000之间
        int code;
        do{
            code = random.nextInt(900000)+100000;
        }while(isExistCode(code));//如果重复重新生成

        express.setCode(code);
        express.setX(x);
        express.setY(y);
        expressList.add(express);
        IOUtil.writeFile(expressList,FILE_NAME);
        return express;
    }

    /**
     * 查询指定坐标处是否有快递
     * @param x
     * @param y
     * @return
     */
    public  boolean  isExist(int x,int y){
        for (Express express: expressList){
            if(express.getX()==x && express.getY()==y){
                return true;
            }
        }
        return false;
    }

    /**
     * 判定取件码是否重复
     * @param code
     * @return
     */
    public  boolean  isExistCode(int code){
        for (Express express: expressList){
            if(express.getCode()==code){
                return true;
            }
        }
        return false;
    }
    /**
     *获取所有快递
     */
    public List<Express> getExpressList() {
        return expressList;
    }
}
