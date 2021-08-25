package com.kkb.pojo;

/**
 * 快递实体类
 * @author Yan Wang
 * @version 1.0
 */
public class Express {

    private String number; //快递单号
    private String company; //所属公司
    private Integer code; //取件码

    //构造方法
    public Express(){
    }

    @Override
    public String toString() {
        return number+"-"+company+"-"+code;
    }

    public Express(String number, String company, Integer code){
        this.number =number;
        this.company = company;
        this.code = code;
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
}
