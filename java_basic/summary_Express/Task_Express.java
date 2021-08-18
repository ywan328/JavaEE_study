package com.kkb.task;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

/**
 * 快递 E栈 训练任务
 * @author Yan  Wang
 */
public class Task_Express {
    public static Scanner input = new Scanner(System.in);
    public static String[] numberArr = new String[100]; //快递单号的数组
    public static String[] companyArr = new  String[100];//公司名称数组
    public static int[] codeArr = new int[100];//取件码数组
    public static int index = 0;//快递柜当中共有多少个快递
    public static Random random = new Random();
    public static void main(String[] args) {
        //展示菜单
        while(true){
        int id = startMenu();
        if(id==0)
            return;
        }
    }

    /**
     * 开始菜单
     */

    public static int startMenu() {
        System.out.println("==========欢迎使用新职课快递柜=============");
        System.out.print("请输入您的身份: 1-快递员 2-用户 0-退出");
        int id = 0;
        do {
            id = input.nextInt();
            if (id == 1) {//快递员--展示快递员的菜单
                deliverymanMenu();
                break;
            } else if (id == 2) {//普通用户
                userMenu();
                break;
            } else if (id==0) {
                System.out.println("谢谢使用!");
                return 0;
            }else{
                System.out.println("选择有误!请重新新输入: ");
            }
        } while (true);
        return id;
    }

    /**
     * 普通用户菜单
     */
    public static void userMenu(){
        System.out.print("请输入取件码： ");
        int code = input.nextInt();
        int codeIndex = isExist(code);
        if(codeIndex ==-1){
            System.out.println("未找到快递");
        }else{
            del(codeIndex);
            System.out.println("取件成功");
        }
    }

    /**
     * 快递员菜单
     */
    public static void deliverymanMenu() {
        System.out.println("请选择操作: 1-存快递 2-删除快递 3-修改快递信息 4-查看所有快递");
        int id= input.nextInt();
        if(id==1){
            saveExpress();
        }else if(id==2){
            delExpress();
        }else if(id==3){
            System.out.print("请输入要修改的快递单号: ");
            String number = input.next();
            int updateIndex = findByNumber(number);
            if(findByNumber(number)==-1){
                System.out.println("未找到快递");
            }else{
                System.out.print("请输入新的快递单号:");
                number = input.next();
                System.out.print("请输入新的公司名称: ");
                String company = input.next();
                numberArr[updateIndex] = number;
                companyArr[updateIndex] = company;
                System.out.println("修改成功!");
            }
        }else if(id==4){
            printAll();
        }
    }

    /**
     * 保存快递
     */
    public static void saveExpress(){
        System.out.print("请输入快递单号：");
        String number = input.next();
        System.out.print("请输入公司名称:");
        String company = input.next();
        //自动生成取件码 100-900
        int code = random.nextInt(900)+100;
        numberArr[index] = number;
        companyArr[index] = company;
        while(isExist(code)!=-1){
            code = random.nextInt(900)+100;
        }
        codeArr[index] = code;
        index++;
        System.out.println("快递已存入,取件码是: "+code);
    }
    /**
     * 删除快递
     */
    public static void delExpress(){
        System.out.println("请输入要删除的快递单号：");
        String number =  input.next();
        int delIndex = findByNumber(number);
        if(delIndex==-1){
            System.out.println("未找到快递！");
        }else{
            //删除
            del(delIndex);
            System.out.println("删除成功！");
        }
    }

    public static void del(int delIndex){
        if(delIndex!=numberArr.length-1){
            for(int i=delIndex;i<index;i++){
                numberArr[i]=numberArr[i+1];
                companyArr[i]=companyArr[i+1];
                codeArr[i]=codeArr[i+1];
            }
        }
        index--;
    }
    /**
     * 查看所有快递
     */
    public static void printAll(){
        System.out.println("-------所有快递信息--------");
        System.out.println("快递单号\t公司名称\t取件码");
        for (int i = 0;i < index;i++) {
            System.out.println(numberArr[i]+"\t"+companyArr[i]+"\t"+codeArr[i]);
        }
    }

    /**
     * 根据快递单号
     * @param number 找到的下标 -1 表示找到
     * @return
     *
     */
    public static int findByNumber(String number){
        for (int i =0; i < index; i++){
            if(numberArr[i].equals(number)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 存快递功能
     *
     *
     */

    //判断取件码是否重复
    public static  int isExist(int code){
        for (int i = 0;i< index; i++){//遍历取件码数组
            if(codeArr[i]==code) {//判定是否重复
                return i;
            }
        }
        return -1;
    }
}

