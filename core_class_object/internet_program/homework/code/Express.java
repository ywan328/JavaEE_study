package com.kkb.express;

import java.io.Serializable;

public class Express implements Serializable {
    private String number;//快递单号
    private String company;//公司
    private int code;//取件码
    private int x;
    private int y;

    /**
     * 定义无参构造方法
     */
    public Express() {
    }

    /**
     * 定义全参构造方法
     */
    public Express(String number, String company, int code, int x, int y) {
        this.number = number;
        this.company = company;
        this.code = code;
        this.x = x;
        this.y = y;
    }

    /**
     * 使用setter和getter设置和获取值
     */
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * toString将信息转化为字符串形式
     */
    @Override
    public String toString() {
        return "快递信息[" +
                "快递单号：" + getNumber() + ' ' +
                ", 快递公司：" + getCompany() + ' ' +
                ", 取件码：" + getCode() + " , 在第" + (getX() + 1) + "行 第" + (getY() + 1) + "列柜子" +
                ']';
    }
}

