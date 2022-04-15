package com.linzlb.javaguide.datastructure.myarraylist;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/17 16:15
 * @Function: ArrayList自己的简单实现
 */
public class MyArrayList {

    //非私有，以简化嵌套类访问
    //transient 增已经实现的序列化的类中，不允许某变量序列化
    transient Object[] elementData;

    //默认容量
    private static final int DEFAULT_CAPACICT = 10;

    //空实例的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //ArrayList.size()
    private int size;


    public MyArrayList(int initCapacity) {
        if (initCapacity > 0){
            this.elementData = new Object[initCapacity];
        } else if (initCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity:" +
                    initCapacity);
        }
    }

    public MyArrayList() {
        this(DEFAULT_CAPACICT);
    }

    public void add(Object o){
        //1.判断数据容量是否大于 elementData,大于需要扩容
        ensureExplicitCapacity(size+1);
        //2.赋值
        elementData[size++] = o;
    }

    private void ensureExplicitCapacity(int minCapacity){
        if (size == elementData.length){
            //需要扩容，扩容1.5倍, 注意old值为1的时候
            int oldCapacity = elementData.length;
            //将oldCapacity 右移一位，其效果相当于oldCapacity /2，
            //我们知道位运算的速度远远快于整除运算，整句运算式的结果就是将新容量更新为旧容量的1.5倍，
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //如果新容量 < 最小容量 ，将最小容量赋值给新容量
            //如果 oldCapacity=1，则 minCapacity=1+1=2 newCapacity=1+(1>>1)=1
            if (newCapacity < minCapacity){
                newCapacity = minCapacity;
            }
            //创建新数组
            Object[] objects = new Object[newCapacity];
            //将数据复制到新数组
            System.arraycopy(elementData, 0, objects, 0, elementData.length);
            //修改引用
            elementData = objects;
        }
    }

    public Object get(int index){
        //检测是否下标越界
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    public Object remove(int index){
        rangeCheck(index);
        //查找元素
        Object oldValue = elementData[index];
        //找出置换结束位置
        int numMoved = size - index - 1;
        if (numMoved > 0){
            //从index+1开始，将值覆盖为index-numMoved的值
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        elementData[--size] = null;//clear to let GC do its work
        return oldValue;
    }

    public boolean remove(Object o){
        for (int index = 0; index < size; index++){
            if (o.equals(elementData[index])){
                remove(index);
                return true;
            }
        }
        return false;
    }

}