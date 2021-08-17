package com.kkb.task;

/**
 * 3、 两数之和
 * 给定一个整数数组 nums 和一个目标值 target， 请你在该数组中找出和为目标值的那两个整数， 并输出他们的数组下标
 * 假设每种输入只会对应一个答案， 不能重复利用这个数组中同样的元素。
 * 		示例:
 * 		给定 nums = [2, 7, 11, 15], target = 9
 * 		因为 nums[0] + nums[1] = 2 + 7 = 9
 * 		所以输出 0， 1
 */
public class Task_twoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target = 9;
        //首先冒泡排序从小到大排序
        int temp = 0;
        //外层循环控制的是， 比较的轮数。
        //外层循环次数： length-1
        for(int i=0;i<nums.length-1;i++) {
            //内层循环控制的是，每轮比较的次数
            //第i轮（i从0开始计算）， 比较次数为：length-i-1
            for(int j=0;j<nums.length-i-1;j++) {
                if(nums[j]>nums[j+1]) {
                    //两两相比， 满足移动条件
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        //排序已经完成。 下面是遍历打印查看的过程
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
            System.out.println();
        }
        //循环每一个元素，作为第一个和数
        //利用二分查找思想尝试找第二个和数
        int num1 = 0;//第一个和数
        int num2 = 0;//第二个和数
        int found = -1;//找到的第二个和数的下标
        for(int i=0; i<nums.length; i++) {

            //二分查找num2
            num1 = nums[i];
            num2 = target- num1;

            //1.	最小范围下标
            int minIndex = 0;
            //2.	最大范围下标
            int maxIndex = nums.length-1;
            //3.	中间数据下标
            int centerIndex = (minIndex+maxIndex)/2;
            while(true) {
                if(nums[centerIndex]>num2) {
                    //中间数据较大
                    maxIndex = centerIndex-1;
                }else if(nums[centerIndex]<num2) {
                    //中间数据较小
                    minIndex = centerIndex+1;
                }else {
                    //找到了数据  数据位置：centerIndex
                    break;
                }
                //没有找到数据
                if(minIndex > maxIndex) {
                    centerIndex = -1;
                    break;
                }
                //当边界发生变化， 需要更新中间下标
                centerIndex = (minIndex+maxIndex)/2;
            }
            found = centerIndex; //num2的下标
            if(found!=-1) {
                System.out.println("两个和数的下标为："+i + ", "+ found);
                break;
            }
        }
        if(found==-1){//循环完成还是没有找到
            System.out.println("数组中不存在两个数加和刚好等于"+target);
        }
    }

}
