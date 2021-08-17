package com.kkb.task;
/**
 * 4、 排序并查找
 * 对数组{1， 3， 9， 5， 6， 7， 15， 4， 8}进行排序， 然后使用二分查找 6并输出排序后的下标。
 */
public class Task_sortAndSearch {
    public static void main(String[] args) {
        int[] nums={1,3,9,5,6,7,15,4,8};
        int target = 6;
        //首先冒泡排序从小到大排序
        int temp=0;
        //外层循环控制的是， 比较的轮数。
        //外层循环次数： length-1
        for (int i = 0; i < nums.length - 1; i++) {
            //内层循环控制的是，每轮比较的次数
            //第i轮（i从0开始计算）， 比较次数为：length-i-1
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //两两相比， 满足移动条件
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        //排序已经完成。 下面是遍历打印查看的过程
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
            System.out.println();
        }
        //二分查找目标数
        //关键的三个变量：
        //1.	最小范围下标
        int minIndex = 0;
        //2.	最大范围下标
        int maxIndex = nums.length - 1;
        //3.	中间数据下标
        int centerIndex = (minIndex + maxIndex) / 2;
        while (true) {
            System.out.println("循环了一次");
            if (nums[centerIndex] > target) {
                //中间数据较大
                maxIndex = centerIndex - 1;
            } else if (nums[centerIndex] < target) {
                //中间数据较小
                minIndex = centerIndex + 1;
            } else {
                //找到了数据  数据位置：centerIndex
                break;
            }
            //没有找到数据
            if (minIndex > maxIndex) {
                centerIndex = -1;
                System.out.println("没有找到数据");
                break;
            }
            //当边界发生变化， 需要更新中间下标
            centerIndex = (minIndex + maxIndex) / 2;
        }

        System.out.println("目标位置为：" + centerIndex);
    }
}
