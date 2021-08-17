package com.kkb.task;

public class Task_moveZero {
    public static void main(String[] args) {
        int[] nums ={0,1,0,3,12};
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
        int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }
            else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];
                nums[i]=0;
            }
        }
        System.out.println();
        System.out.println("移动0后：");
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
