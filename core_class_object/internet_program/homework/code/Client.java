package com.kkb.main;

import com.kkb.view.ExpressView;

import java.io.*;
import java.net.Socket;

public class Client {
    public static ExpressView v = new ExpressView();

    //客户端
    public static void main(String[] args) throws IOException {
        //      连接到服务器
        Socket socket = new Socket("127.0.0.1",55555);

        //给服务器发消息
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);

        //接收服务器的消息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //读取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String receive,send;

        //进入系统
        receive = br.readLine();
        System.out.println(receive);

        //主菜单与登录界面
        while(true){
            //收消息，服务器发送的提示内容
            receive = br.readLine();
            System.out.println(receive);
            if("登陆成功！".equals(receive) ){
                int num = Integer.parseInt(br.readLine());
                if(num == 1){
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    break;
                }else if(num == 2){
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    break;//考虑到只题目要求用户登录成功提示登录成功并显示功能模块
                    //因此登陆成功并显示具体操作时程序便结束
                }
            }else if("用户名或密码错误！登录失败！".equals(receive)){
                break;
            }

            //发消息
            send = input.readLine();
            ps.println(send);

            if("0".equals(send)){
                System.out.println(v.bye());
                break;
            }

        }//end while 聊天结束

        input.close();
        ps.close();
        br.close();
        socket.close();
    }

}
