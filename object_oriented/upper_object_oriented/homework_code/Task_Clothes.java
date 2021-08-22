package com.kkb.task.OO;

/**
 * 通过类描述衣服， 每个衣服对象创建时需要自动生成一个序号值。 要
 * 求：每个衣服的序号是不同的， 且是依次递增 1 的。
 */
public class Task_Clothes {
    private int clothId;
    private static int num = 1000;

    public Task_Clothes(){
        //序号自增1
        clothId = num;
        num++;
    }
    public int getClothId(){
        return clothId;
    }

    public void setClothId(int clothId){
        this.clothId = clothId;
    }
}
