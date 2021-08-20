package com.kkb.task.test;

import com.kkb.task.OO.Task_Game;

public class GameTest {
    public static void main(String[] args) {
        //创建对象
        Task_Game game = new Task_Game("王者荣耀", "竞技类", 100, 10, "特别好玩,容易上瘾");
        //调用方法
        game.show();

    }
}
