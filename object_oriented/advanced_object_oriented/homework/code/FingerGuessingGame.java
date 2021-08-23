package com.kkb.task.OO;

import java.util.Random;

import java.util.Scanner;
/**
 * 3. 猜拳游戏
 * 通过控制台方式实现一个人机对战的猜拳游戏， 用户通过输入（1.剪刀 2.石头 3.布）
 * 机器随机生成（1.剪刀 2.石头 3.布） ， 胜者积分，
 * n 局以后通过积分的多少判定胜负。
 *
 * 猜拳游戏包含方法：游戏主流程gameFlow()、当局游戏信息展示gameInfo()、判定这一局结果roundResult()，判定最终胜负FinalResult()、
 *
 */
public class FingerGuessingGame {
    //游戏相关的引用
    Scanner input;
    Random random;
    GamePlayer player;//玩家角色
    GamePlayer robot;//电脑角色
    int totalRound = 0; //第几局
    //引用指向新建的对象
    {
        //玩家的角色
        player = new GamePlayer();
        //电脑的角色
        robot = new GamePlayer();

        input = new Scanner(System.in);
        random = new Random();
    }

    //游戏的主流程显示
    public void gameFlow() {
        System.out.println("******************");
        System.out.println("*****猜拳游戏******");
        System.out.println("******************");
        System.out.println("出拳规则：1、剪刀    2、石头     3、布");
        //用户的角色名
        System.out.println("请输入你的角色名：");
        player.setUsername(input.nextLine());
        //电脑的角色名随机生成
        robot.setUsername("robot"+random.hashCode());
        //比赛双方信息
        System.out.println(player.getUsername()+"   VS   "+robot.getUsername());


        //循环流程进行比赛
        while(true) {
            System.out.println("请问是否开始游戏  Y/N");
            String s = input.next();
            if(s.equals("Y") || s.equals("y")) {
                //进入游戏
                System.out.println("进入游戏");
                gameInfo();	//代表猜拳游戏的每一局
                break;
            }else if(s.equals("N") || s.equals("n")){
                //游戏结束，或退出游戏
                System.out.println("退出游戏");
                FinalResult();
                break;
            }else {
                //继续选择
            }
        }
    }


    //每一局具体的信息
    public void gameInfo() {
        System.out.println("请出拳：1、剪刀   2、石头   3、布（请输入对应的数字）");
        int go = input.nextInt();
        //把手势存入到玩家角色的对象中
        player.setGesture(go);
        //电脑的手势需要随机选出
        robot.setGesture(random.nextInt(3)+1);		//根据数字显示对应的手势1 2 3
        System.out.println("你出的是："+getStringOfgesture(player.getGesture()));		//玩家出拳
        System.out.println(robot.getUsername()+"出拳的是："+getStringOfgesture(robot.getGesture()));
        roundResult();
        while(true) {
            System.out.println("是否开始下一局：Y/N");
            String s = input.next();
            if(s.equals("Y") || s.equals("y")) {
                //递归，自己调用自己，进行下一局
                gameInfo();
                break;
            }else if(s.equals("N") || s.equals("n")) {
                //结束游戏，计算最终结果
                FinalResult();
                break;
            }
        }
    }


    private void FinalResult() {
        System.out.println("游戏结束，总结果如下：");
        System.out.println(player.getUsername()+"   VS   "+robot.getUsername());
        System.out.println("对战次数："+totalRound+"\n");
        System.out.println("姓名\t得分");
        System.out.println(robot.getUsername()+"\t"+robot.getScore());
        System.out.println(player.getUsername()+"\t"+player.getScore()+"\t");
        //结果
        if(robot.getScore() == player.getScore()) {
            System.out.println("你们打成平局");
        }else if(robot.getScore() < player.getScore()){
            System.out.println("玩家获胜！");
        }else {
            System.out.println("电脑获胜！");
        }

    }


    //每次出拳的结果判断
    /*电脑赢
     * 1剪刀- 2石头   ==-1
     * 2石头- 3布   ==-1
     * 3布- 1剪刀   ==2
     */
    private void roundResult() {
        totalRound++ ;//局数自增1
        //玩家出拳-电脑出拳
        //用玩家的出拳-电脑的出拳
        int i = player.getGesture() - robot.getGesture();
        if(i == -1 || i==2) {
            System.out.println("这一句局"+robot.getUsername()+"赢了");
            robot.setScore(robot.getScore()+1);//当前积分加一
            //在对象中把电脑分数+1
        }else if(i ==0) {
            System.out.println("这一句局是平局");
        }else {
            System.out.println("这一句局"+player.getUsername()+"赢了");
            player.setScore(player.getScore()+1);
            //在对象中把玩家分数+1
        }
    }

    //根据int类型的数字返回字符串类型的手势
    public String getStringOfgesture(int gesture) {
        if(gesture == 1) {
            return "剪刀";
        }else if(gesture ==2) {
            return "石头";
        }else {
            return "布";
        }
    }



    //测试
    public static void main(String[] args) {
        FingerGuessingGame game = new FingerGuessingGame();
        game.gameFlow();

    }

}
//参考：设计一个猜拳游戏，完成人机猜拳互动游戏的开发。 https://blog.csdn.net/qq_45809896/article/details/107157992