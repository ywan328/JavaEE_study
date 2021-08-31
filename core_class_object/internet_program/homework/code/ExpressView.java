package com.kkb.view;

import com.kkb.dao.ExpressDao;
import com.kkb.exception.OutNumberBoundException;
import com.kkb.express.Express;

import java.util.Map;
import java.util.Scanner;

public class ExpressView {
    public static Scanner input = new Scanner(System.in);
    public static ExpressDao dao = new ExpressDao();

    /**
     * 进入系统
     * @return
     */
    public  static String welcome(){
        System.out.println("欢迎进入快递管理系统！");
        return null;
    }

    /**
     * 退出系统
     * @return
     */
    public static Object bye(){
        System.out.println("感谢使用快递管理系统！");
        return null;
    }

    /**
     * 主菜单，系统界面
     * @return
     */
    public static String mainMenu(){
        return "请选择您的身份:  1.管理员  2.普通用户  0.退出";
    }
    /**
     * 登录界面，输入账号
     */
    public static String loginName(){
        String s = "请输入登录用户名:";
        return s;
    }

    /**
     * 登录界面，输入密码
     */
    public static String loginPassword(){
        String s = "请输入登录密码:";
        return s;
    }

    /**
     * 管理员菜单
     */
    public static int managerMain(){
        int managerNum = 0;
        do{
            System.out.println("尊敬的管理员，您好！");
            System.out.println("请选择您要进行的操作：");
            System.out.println("1.录入快递");
            System.out.println("2.删除快递");
            System.out.println("3.修改快递");
            System.out.println("4.查看所有快递");
            System.out.println("0.返回上一级界面");
            String s = input.nextLine();
            try{
                managerNum = validNum(s,0,4);
                break;
            }catch(NumberFormatException | OutNumberBoundException e){
                System.out.println(e.getMessage());
            }
        }while(true);
        return managerNum;
    }

    /**
     * 判断输入是否为数字、是否在有效范围内
     * @param s
     * @param begin
     * @param end
     * @return
     * @throws NumberFormatException
     */
    private static int validNum(String s,int begin,int end) throws NumberFormatException, OutNumberBoundException {
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

    /**
     * 录入快递
     */
    public static Express insertExpress(){
        System.out.print("请输入快递单号：");
        String number = input.nextLine();
        System.out.print("请输入快递公司：");
        String company = input.nextLine();
        Express e = new Express();
        e.setNumber(number);
        e.setCompany(company);
        return e;
    }

    /**
     * 删除快递
     */
    public static int isDeleteExpress() throws NumberFormatException, OutNumberBoundException {
        do{
            System.out.println("是否进行删除操作？");
            System.out.println("1.确认删除");
            System.out.println("0.取消操作");
            String s = input.nextLine();
            int deleteNum = -1;
            try{
                deleteNum = validNum(s,0,1);
                return deleteNum;
            }catch(NumberFormatException | OutNumberBoundException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }

    /**
     * 输入快递单号
     */
    public static String findByNumber(){
        System.out.print("请输入快递单号：");
        String s = input.nextLine();
        return s;
    }

    /**
     * 更新快递
     */
    public Express updateExpress(){
        Express e = new Express();
        String number;
        do{
            System.out.print("请输入新的快递单号：");
            number = input.nextLine();
            if(dao.findExpressIsExist(number) == 1){
                hasExist();
            }
        }while(dao.findExpressIsExist(number) == 1);
        System.out.print("请输入新的快递公司：");
        String company = input.nextLine();
        e.setNumber(number);
        e.setCompany(company);
        return e;
    }

    /**
     * 打印快递信息，即遍历
     */
    public static void printAllExpress(Map<String, Express> expressMap){
        System.out.println("当前快递柜存储情况：");
        for(Express express:expressMap.values()){
            printExpress(express);
        }
    }

    /**
     * 输入取件码
     */
    public static int findByCode(){
        int code = -1 ;
        do{
            System.out.print("请输入取件码：");
            String s = input.nextLine();
            try{
                code = validNum(s,100000,999999);
                break;
            }catch(NumberFormatException | OutNumberBoundException e){
                System.out.println(e.getMessage());
            }
        }while(true);
        return code;
    }

    /**
     * 打印单条快递信息
     */
    public static void printExpress(Express e){
        System.out.println(e.toString());
    }

    /**
     *打印快递位置信息
     */
    public static void printExpressLocation(Express e){
        System.out.println("您的快递存储在快递柜的第" + (e.getX() + 1) + "排,第" + (e.getY() + 1) + "列,取件愉快~");
    }

    /**
     * 操作成功
     */
    public static void success(){
        System.out.println("操作成功！");
    }

    /**
     * 已经存在
     */
    public static void hasExist(){
        System.out.println("该单号已经存在！");
    }

    /**
     * 快递不存在
     */
    public static void noExist(){
        System.out.println("快递不存在！");
    }
}

