package com.kkb.pojo;

import java.io.Serializable;

import java.io.Serializable;
/**
 * 快递实体类
 * @author Yan Wang
 * @version 1.0
 */
public class Express implements Serializable {

    private String number; //快递单号
    private String company; //所属公司
    private Integer code; //取件码
    //坐标
    private Integer x;
    private Integer y;

    //构造方法
    public Express(){
    }

    public Express(String number, String company, Integer code, Integer x, Integer y) {
        this.number = number;
        this.company = company;
        this.code = code;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Express{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
