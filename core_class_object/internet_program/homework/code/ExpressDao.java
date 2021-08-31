package com.kkb.dao;

import com.kkb.exception.OutNumberBoundException;
import com.kkb.express.Express;
import com.kkb.util.IOUtil;
import com.kkb.view.ExpressView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExpressDao {
    public static ExpressView v = new ExpressView();
    public static Map<String, Express> expressMap = new HashMap<>();//key为快递单号
    private static final String FILE_NAME = "express.txt";

    /**
     * 初始化数据
     * 如果文件不存在，则创建文件
     * 如果文件存在，则初始化数据
     */
    static{
        File file = new File(FILE_NAME);
        if(!file.exists()){//如果文件不存在，则创建文件
            try {
                if(file.createNewFile()){
                    System.out.println("文件创建成功！");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else{
            try {
                Object obj = IOUtil.readFile(FILE_NAME);//读取
                if(obj != null && obj instanceof Map){//如果对象不为空，并且是Map集合
                    expressMap = (Map<String, Express>) obj;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }


//    /**
//     * 初始化快递柜，从文件中读取数据
//     */
//    public ExpressDao() {
//        try {
//            Object obj = IOUtil.readFile(FILE_NAME);//读取
//            if(obj != null && obj instanceof Map){//如果对象不为空，并且是Map集合
//                expressMap = (Map<String, Express>) obj;
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }



    /**
     * 添加快递
     */
    public static Express add(Express express) throws Exception{
        Random random = new Random();
        if(expressMap.size() == 100){
            throw new Exception("快递柜已满！不能放入快递了！");
        }
        int x,y;
        do{
            x = random.nextInt(10);
            y = random.nextInt(10);
        }while(isExist(x,y));

        int code;
        do{
            code = random.nextInt(100000)+900000;
        }while(isExistCode(code));

        express.setCode(code);
        express.setX(x);
        express.setY(y);
        expressMap.put(express.getNumber(),express);
        IOUtil.writeFile(expressMap,FILE_NAME);
        return express;
    }

    /**
     * 判断快递柜的对应位置是否已存在快递
     */
    public static boolean isExist(int x, int y){
        for(Express express : expressMap.values()){
            if(express.getX() == x && express.getY() == y){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断取件码是否重复
     */
    public static boolean isExistCode(int code){
        for(Express express : expressMap.values()){
            if(express.getCode() == code){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据快递单号查找快递，返回快递对象
     */
    public Express findExpressByNumber(String number){
        for(Express express : expressMap.values()){
            if(express.getNumber().equals(number)){
                return express;
            }
        }
        return null;
    }


    /**
     * 根据快递单号删除快递
     */
    public static boolean delete(String number) throws Exception {
        expressMap.remove(number);
        IOUtil.writeFile(expressMap,FILE_NAME);
        return true;
    }

    /**
     * 根据快递单号查找快递，如果不存在返回-1
     */
    public static int findExpressIsExist(String number){
        for(Express express:expressMap.values()){
            if(express.getNumber().equals(number)){
                return 1;
            }
        }
        return -1;
    }

    /**
     *修改快递信息
     */
    public static void updateExpress(String number, Express newExpress) throws Exception {
        Express oldExpress = expressMap.get(number);//获取旧的快递信息
        oldExpress.setCompany(newExpress.getCompany());
        oldExpress.setNumber(newExpress.getNumber());
        IOUtil.writeFile(expressMap,FILE_NAME);
    }


    /**
     *获取所有的快递信息
     * @return
     */
    public Map<String,Express> getExpressMap(){
        return expressMap;
    }

    /**
     * 通过取件码查询是否存在
     */
    public static Express findByExpressCode(int code){
        Express e = new Express();
        e.setCode(code);
        for(Express express : expressMap.values()){
            if(express.getCode() == code){
                return express;
            }
        }
        return null;
    }

    public static int validNum(String s, int begin, int end) throws NumberFormatException, OutNumberBoundException {
        try{
            int num = Integer.parseInt(s);
            if (num < begin || num > end){
                throw new OutNumberBoundException("数字的范围必须在" + begin + "和" + end +"之间");
            }
            return num;
        }catch(NumberFormatException | OutNumberBoundException e){
            throw new NumberFormatException("输入的必须是数字！");
        }
    }

    public static boolean judgeLoginID(int n,String s1,String s2){//s1为用户名，s2为密码
        if(n == 1){//管理员，用户名为admin，密码为abc
            if("admin".equals(s1) && "abc".equals(s2)){//账号密码完全相同，即登陆成功
                return true;
            }
        }else if(n == 2){//用户,用户名为user，密码为123
            if("user".equals(s1) && "123".equals(s2)){//账号密码完全相同，即登陆成功
                return true;
            }
        }
        return false;
    }

}

