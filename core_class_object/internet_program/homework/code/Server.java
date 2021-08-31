package com.kkb.main;

import com.kkb.exception.OutNumberBoundException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.kkb.main.Platform.*;

public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
    public static void start() throws IOException {
        //搭建服务器
        ServerSocket server = new ServerSocket(55555);

        //进入服务器
        System.out.println("服务器启动完毕，等待客户连接中...");

        while(true){
            //等待客户端连接
            Socket socket = server.accept();
            System.out.println("一个客户端连接了！");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    init(server,socket);//init方法来实现数据的交互
                }
            }).start();
        }
    }

    private static void init(ServerSocket server, Socket socket) {
        try {
            //接收客户消息，获取输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //发消息给客户，获取输出流
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);

            //与客户端交互
            String receive,send;

            //进入系统
            send = v.welcome();
            ps.println(send);
            ps.flush();

            //主菜单
            //发消息，提示用户输入,1管理员，2普通用户，0退出
            send = v.mainMenu();
            ps.println(send);
            m: while (true) {
                int mainNumber;
                String name,password;
                do{
                    //收消息，1表示管理员，2表示普通用户，0表示退出
                    receive = br.readLine();
                    try{
                        mainNumber = dao.validNum(receive,0,2);
                        break;
                    }catch(NumberFormatException | OutNumberBoundException e){
                        ps.println("请输入0~2之间的有效数字: 1.管理员  2.普通用户  0.退出");
                    }
                }while(true);
                switch (mainNumber){
                    case 0://结束使用
                        System.out.println("客户端已断开与服务器的连接！");
                        break m;
                    default:{
                        //输入用户名
                        send= v.loginName();
                        ps.println(send);
                        name = br.readLine();
                        //输入密码
                        send = v.loginPassword();
                        ps.println(send);
                        password = br.readLine();
                        if (dao.judgeLoginID(1, name, password) || dao.judgeLoginID(2, name, password)) {
                            ps.println("登陆成功！");
                            ps.println(mainNumber);
                        }else{
                            ps.println("用户名或密码错误！登录失败！");
                            break m;
                        }
                        if(mainNumber == 1){
                            //managerPlatform();
                            ps.println("尊敬的管理员，您好！");
                            ps.println("请选择您要进行的操作：");
                            ps.println("1.录入快递");
                            ps.println("2.删除快递");
                            ps.println("3.修改快递");
                            ps.println("4.查看所有快递");
                            ps.println("5.返回上一级界面");
                            break m;//考虑到只题目要求用户登录成功提示登录成功并显示功能模块
                            //因此登陆成功并显示具体操作时程序便结束
                        }else if(mainNumber == 2){
                            // userPlatform();
                            ps.println("尊敬的用户，您好！");
                            ps.println("请输入取件码：");
                            break m;//考虑到只题目要求用户登录成功提示登录成功并显示功能模块
                            //因此登陆成功并显示具体操作时程序便结束
                        }
                    }
                }//end switch
            }//end while
            input.close();
            br.close();
            ps.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
