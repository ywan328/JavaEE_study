package com.kkb.task.OO;

/**
 * 2. 试题： 设置一个类， 命名为 MyList
 * 类中包含属性： Object[] element
 * 方法有如下几个：
 * 1. 增加方法 add ： 可以向数组属性中依次存储 Object， 数组内容存满时， 需实现动态扩容（详解在下面） 。
 * 2. 删除方法 remove ： 可以根据数据或下标， 从数组属性中删除Object 数据， 删除后， 数组后续元素需前移。
 * 3. 查询方法 get ： 方法传入下标， 返回数组中指定下标的数据。
 * 4. 当前存储数据量 size ： 获取当前存储的有效数据长度
 * 动态扩容详解： 无需真正增加原数组的容量， 只用将原内容复制到新的大数组， 然后让原数组名称重新等于大数组即可。
 * 	由于原数组数据在堆中，失去引用会被 GC 自动回收。
 */
public class Task_MyList {
    //属性
    private Object[] element;//代表数组
    private int capacity; //容量
    private int size;//目前的数组元素个数

    //构造方法
    public Task_MyList() {
        size = 0; //实际大小默认就是0
        capacity = 7; //默认容量--可以自己定义
        element = new Object[capacity]; //分配数组的空间一定开辟就不能改变大小
    }
    //方法

    /**
     * 根据指定对象去删除
     * @param obj
     * @return
     */
    public Object remove(Object obj){
        //先判定该对象是否存在
        for (int i = 0; i < element.length;i++){
            if(element[i]!=null && obj ==element[i]){
                return remove(i);
            }
        }
        return null;//该数组中没有指定的对象
    }

    /**
     * 根据下标删除
     * @param index
     * @return
     */
    public Object remove(int index){
        //如果是最后一个元素
        if(index==size-1){
            size--;
            return element[index];
        }
        //数组后续元素需前移
        Object obj = element[index];
        for(int i=index;i<size;i++){
            element[i]=element[i+1];
        }
        size--;//删除成功之后实际大小要-1
        return obj;
    }
    /**
     * 查询方法
     * @param index
     * @return
     */
    public Object get(int index){

        return element[index];
    }
    /**
     * 添加元素
     * @param obj
     */
    public void add(Object obj){
        if (size == capacity) {//数组内容是否存满,满了要扩容
                //动态扩容
                Object[] newArr = new Object[capacity * 2];//新的大小数组可改变,比原来的大就行
                //将原有数组的元素复制到新数组中
                for (int i = 0; i < element.length; i++) {
                    newArr[i] = newArr[i];
                }
                //让原数组的名称重新等于新数组即可
                element = newArr;
        }
        element[size] = obj;//存放元素
        size++;//实际大小+1
    }

    public int getSize(){
        return size;
    }


}
