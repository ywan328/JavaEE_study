package com.kkb.main;

import com.kkb.dao.ExpressDao;
import com.kkb.exception.OutNumberBoundException;
import com.kkb.express.Express;
import com.kkb.view.ExpressView;

import java.util.Scanner;

public class Platform {
    public static ExpressView v = new ExpressView();
    public static ExpressDao dao = new ExpressDao();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception, OutNumberBoundException {
        v.welcome();

        //调用主菜单进入相应的使用者（用户or管理员）平台
        m: while(true){
            int mainNum = Integer.parseInt(v.mainMenu());//调用主菜单
            switch(mainNum){
                case 0://结束使用
                    break m;
                case 1://进入管理员平台
                    managerPlatform();
                    break ;
                case 2://进入用户平台
                    userPlatform();
                    break ;
            }
        }// end while
        v.bye();
    }//end main


    /**
     * 管理员操作界面
     */
    public static void managerPlatform() throws OutNumberBoundException, Exception{
        w:while(true){
            int managerNum = v.managerMain();
            switch(managerNum){
                case 0:{//返回上一级页面
                    return;
                }
                case 1:{//1.录入快递
                    insert();
                }
                break w;
                case 2:{//2.删除快递
                    delete();
                }
                break w;
                case 3:{//3.修改快递
                    update();
                }
                break w;
                case 4:{//4.查看所有快递
                    printAll();
                }
                break w;
            }// end switch
        }//end while
    }//end managerPlatform

    /**
     * 录入快递
     */
    public static void insert() throws Exception {
        Express e1 = v.insertExpress();//输入快递信息
        Express e2 = dao.findExpressByNumber(e1.getNumber());//通过快递单号查询是否存在
        if (e2 == null){//此快递柜为空，add，生成取件码
            e2 = dao.add(e1);
            v.printExpress(e2);//打印单条快递信息
            v.success();
        }else{
            v.hasExist();
        }
    }

    /**
     * 删除快递
     */
    public static void delete() throws OutNumberBoundException, Exception {
        String num = v.findByNumber();//输入快递单号
        int exist = dao.findExpressIsExist(num);//查找快递是否存在
        if( exist == -1){//快递不存在
            v.noExist();
        }else {
            int deleteNum =v.isDeleteExpress();//确认是否进行删除操作
            if (deleteNum == 1){//确认删除
                dao.delete(num);
                System.out.println("删除成功！");
            }else if (deleteNum == 0){//取消删除
                System.out.println("取消操作成功！");
            }
        }
    }

    /**
     * 修改快递
     */
    public static void update() throws Exception {
        String num = v.findByNumber();//输入快递单号
        Express e1 = dao.findExpressByNumber(num);//通过快递单号查找快递，有则返回快递
        if( e1 == null){//快递不存在
            v.noExist();
        }else {
            String number = dao.findExpressByNumber(num).getNumber();//通过快递单号返回快递信息，获取number
            Express e2 = v.updateExpress();
            dao.updateExpress(number,e2);
            System.out.println("快递信息更新成功！");
            v.printExpress(e1);
        }
    }

    /**
     * 查看所有快递
     */
    public static void printAll(){
        v.printAllExpress(dao.getExpressMap());
    }

    /**
     * 用户操作界面
     */
    public static void userPlatform() throws OutNumberBoundException, Exception {
//        w:while(true){
//            int userNum = v.userMain();
//            switch(userNum){
//                case 0:{//返回上一级页面
//                    v.mainMenu();
//                }
//                break w;
//                case 1:{//1.取出快递
        int code = v.findByCode();
        Express e = dao.findByExpressCode(code);
        if(e == null){
            v.noExist();
        }else {
            System.out.println("取件成功！");
            v.printExpress(e);
            v.printExpressLocation(e);
            dao.delete(e.getNumber());
        }
//                }
//                break w;
//            }// end switch
//        }//end while
    }//end userPlatform
}//end class

