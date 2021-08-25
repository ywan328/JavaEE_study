package com.kkb.dao;

import com.kkb.pojo.Coordinate;
import com.kkb.pojo.Express;

import java.util.Random;

/**
 * 快递管理的dao-----对于所有快递的数据的操作(快递的录入,删除,修改,查看,返回可查看的快递柜)
 * @author Yan Wang
 * @version 1.0
 */
public class ExpressDao {
    private Express[][] expressArr = new Express[10][10]; //表示快递的柜子
    private int size = 0;//表示快递柜中共有多少个快递

    public ExpressDao(){
        //先初始化几个快递
        expressArr[0][0] = new Express("S10001","顺丰",123456);
        expressArr[2][5] = new Express("Y12341","圆通",523656);
        expressArr[6][7] = new Express("Z10011","中通",323356);
        size = 3;
    }

    /**
     * 根据坐标得到快递
     * @param x
     * @param y
     * @return
     */
    public Express findExpressByCoordinate(int x,int y){
        return expressArr[x][y];
    }
    /**
     * 根据我们的取件码查询快递的位置
     */
    public Coordinate findExpressByCode(int code){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(expressArr[i][j]!=null&&expressArr[i][j].getCode()==code)
                    return new Coordinate(i,j);
            }
        }
        return  null;
    }

    /**
     * 修改指定位置的快递
     * @param coordinate
     * @param express
     * @return
     */
    public boolean update(Coordinate coordinate,Express express){
        Express expresses1 = expressArr[coordinate.getX()][coordinate.getY()];
        expresses1.setCompany(express.getCompany());
        expresses1.setNumber(express.getNumber());
        return true;
    }

    /**
     * 根据快递单号去修改快递
     * @param number
     * @return
     */
    public boolean update(String  number,Express newExpress)throws Exception{
        //判断该单号的快递是否存在
        Coordinate coordinate = findExpressByNumber(number);
        if(coordinate ==null) {
            throw new Exception("该快递不存在!");
        }
        //根据我们的坐标获得要修改的快递
        Express expresses = expressArr[coordinate.getX()][coordinate.getY()];
        //直接去修改该快递的公司和单号
        expresses.setCompany(newExpress.getCompany());
        expresses.setNumber(newExpress.getNumber());
        return  true;
    }

    /**
     * 根据快递单号删除快递
     * @param number
     * @return
     */
    public boolean delete(String  number)throws Exception{
        //判断该单号的快递是否存在
        Coordinate coordinate = findExpressByNumber(number);
        if(coordinate ==null){
            throw new Exception("该快递不存在!");
        }
        expressArr[coordinate.getX()][coordinate.getY()]=null;
        size--;//实际快递个数减少
        return true;
    }

    /**
     * 根据快递单号查找快递
     * @param number
     * @return
     */
    public Coordinate findExpressByNumber(String number){
        for(int  i=0; i<10;i++){
            for(int j=0;j<10;j++){
                if(expressArr[i][j]!=null && expressArr[i][j].getNumber().equals(number))
                    return new Coordinate(i,j);
            }
        }
        return null;
    }
    /**
     * 添加一个快递到快递柜中
     * @param express
     * @return
     */
    public Coordinate add(Express express)throws Exception{
        if(size==100){
            //如果满了,就直接报异常
            throw new Exception("快递柜已满!不能放入快递了!");
        }
        Random random =new Random();
        int x,y;
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
        }while(expressArr[x][y]!=null); //该位置有快递,重新生成坐标
        //系统产生随机的取件码 100000-900000之间
        int code;
        do{
            code = random.nextInt(900000)+100000;
        }while(isExistCode(code));//如果重复重新生成
        express.setCode(code);//设置取件码
        expressArr[x][y] = express;
        size++; //添加一个快递,实际数量要+1
        return new Coordinate(x,y);
    }

    public boolean isExistCode(int code){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(expressArr[i][j]!=null && expressArr[i][j].getCode()==code)
                    return true;
            }
        }
        return false;
    }

    /**
     * 获得快递柜
     * @return
     */
    public Express[][] getAllExpress(){
        return expressArr;
    }

    public int getSize() {
        return size;
    }
}
