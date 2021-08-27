package com.kkb.view;


import com.kkb.dao.ExpressDao;
import com.kkb.exception.OutNumberBoundException;
import com.kkb.pojo.Express;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * 视图层:专门跟用户打交道的部分(展示给用户看到,和用户输入的) 输入和输出
 *
 * @author Yan Wang
 * @version 1.0
 */

public class ExpressView {
    private Scanner input = new Scanner(System.in);
    private ExpressDao expressDao = new ExpressDao();
    /**
     * 起始菜单
     *
     * @return
     */
    public int startMenu() {
        int num = 0;
        do {
            System.out.println("------欢迎来到kkb快递管理系统-----");
            System.out.println("请选择: ");
            System.out.println("1.管理员");
            System.out.println("2.普通用户");
            System.out.println("0.退出");
            String strNum = input.nextLine();
            try {
                num = validateNum(strNum, 0, 2);
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            } catch (OutNumberBoundException e) {
                System.err.println(e.getMessage());
                //e.printStackTrace();
            }
        } while (true);
        if (num == 1) {
            administratorMenu();
        } else if (num == 2){
            userMenu();
        } else if (num == 0) {
            System.out.println("谢谢使用!");
        }
        return num;
    }
    /**
     * 用户的菜单
     */
    public void userMenu(){
        int code;
        do{
            System.out.print("请输入取件码: ");
            String strCode = input.nextLine();
            try{
                code = validateNum(strCode,100000,900000);
                break;
            }catch(OutNumberBoundException e) {
                e.printStackTrace();
            }
        }while(true);
        //调用Dao中的方法判断取件码是否存在
        Express express = expressDao.findExpressByCode(code);
        if(express==null){
            System.out.println("该取件码不存在!");
        }else{
            System.out.println("快递信息"+express);
            try {
                if(expressDao.del(express)){
                    System.out.println("从柜子中取出");
                }else{
                    System.out.println("取出失败!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    /**
     * 管理员菜单
     */

    private void administratorMenu() {
        int num;
        do {
            System.out.println("1.快递录入");
            System.out.println("2.快递删除");
            System.out.println("3.快递修改");
            System.out.println("4.查看所有快递");
            System.out.println("0.返回上一级菜单");
            System.out.println("请选择功能序号: ");
            String strNum = input.nextLine();
            try {
                num = validateNum(strNum, 0, 4);
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            } catch (OutNumberBoundException e) {
                System.err.println(e.getMessage());
                //e.printStackTrace();
            }
        }
        while (true);
        if (num == 1) {
            addExpress();
        } else if (num == 2) {
            deleteExpress();
        } else if (num == 3) {
            updateExpress();
        } else if (num == 4) {
            System.out.println("-------查看所有快递---------");
            List<Express> expressList = expressDao.getExpressList();
            for (Express express : expressList) {
                System.out.println(express);
            }
        } else if (num == 0) {
            startMenu();
        }
    }
    /**
     * 修改快递
     */
    public void updateExpress() {
        System.out.println("---------------快递修改------------");
        System.out.println("请输入要修改的快递单号: ");
        String number = input.nextLine();
        Express newExpress = new Express();
        System.out.println("请输入修改后的快递单号和公司: ");
        newExpress.setNumber(input.nextLine());
        newExpress.setCompany(input.nextLine());
        try {
            if (expressDao.update(number, newExpress)) {
                System.out.println("修改成功!");
            } else {
                System.out.println("修改失败!");
            }
        } catch (Exception e) {
            System.out.println("修改失败!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * 删除快递
     */
    private void deleteExpress () {
        System.out.println("-------快递删除---------");
        System.out.println("请输入要删除的快递单号");
        String number = input.nextLine();
        try {
            if (expressDao.del(number)) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
        } catch (Exception e) {
            System.out.println("删除失败!");
            System.err.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    /**
     * 快递的录入
     */
    private void addExpress () {
        System.out.println("-----------快递录入-----------");
        Express express = new Express();
        System.out.println("请输入快递单号和公司");
        express.setNumber(input.nextLine());
        express.setCompany(input.nextLine());
        try {
            express = expressDao.add(express);
            System.out.println("添加成功!放在快递柜中第" + (express.getX() + 1) + "排第" + (express.getY() + 1) + "列");
        } catch (Exception exception) {
            System.out.println("添加失败!");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    /**
     * 验证用户输入是否合法
     * @param strNum
     * @param begin
     * @param end
     * @return
     * @throws NumberFormatException
     * @throws OutNumberBoundException
     */
    private int validateNum (String strNum,int begin, int end)throws NumberFormatException, OutNumberBoundException
    {
        try {
            int num = Integer.valueOf(strNum);
            if (num < begin || num > end) {
                throw new OutNumberBoundException("数字的范围必须在" + begin + "和" + end + "之间!");
            }
            return num;
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("输入的必须是数字!");
        }
    }
}
