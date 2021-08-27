package com.kkb.dao;


import com.kkb.pojo.Express;

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

    public ExpressDao() {
        //先初始化数据
        expressList.add(new Express("S10001","顺丰",123456,0,0));
        expressList.add(new Express("Y12341","圆通",523656,2,5));
        expressList.add(new Express("Z10011","中通",323356,6,7));
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
        return true;
    }

    /**
     * 删除指定的快递
     * @param express
     * @return
     */
    public boolean del(Express express){
        return expressList.remove(express);
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
