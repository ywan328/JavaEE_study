package com.kkb.task.OO;
/**
 * 关于猜拳游戏用户的一系列信息和操作
 * 属性：具体的出拳（剪刀石头布），用户名，当前积分
 *
 */
public class GamePlayer {

    private String username;//用户名
    private int gesture;//具体的出拳
    private int score;//当前积分

    public GamePlayer(String username, int gesture, int score) {
        super();
        this.username = username;
        this.gesture = gesture;
        this.score = score;
    }
    public GamePlayer() {

        super();

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getGesture() {
        return gesture;
    }
    public void setGesture(int gesture) {
        this.gesture = gesture;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "GamePlayer [username=" + username + ", gesture=" + gesture + ", score=" + score + "]";
    }


}
