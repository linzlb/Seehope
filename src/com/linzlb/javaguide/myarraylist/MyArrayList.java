package com.linzlb.javaguide.myarraylist;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/17 16:15
 * @Function:
 */
public class MyArrayList {

    //��˽�У��Լ�Ƕ�������
    //transient ���Ѿ�ʵ�ֵ����л������У�������ĳ�������л�
    transient Object[] elementData;

    //Ĭ������
    private static final int DEFAULT_CAPACICT = 10;

    //��ʵ���Ŀ�����
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
        //1.�ж����������Ƿ���� elementData,������Ҫ����
        ensureExplicitCapacity(size+1);
        //2.��ֵ
        elementData[size++] = o;
    }

    private void ensureExplicitCapacity(int minCapacity){
        if (size == elementData.length){
            //��Ҫ���ݣ�����1.5��, ע��oldֵΪ1��ʱ��
            int oldCapacity = elementData.length;
            //��oldCapacity ����һλ����Ч���൱��oldCapacity /2��
            //����֪��λ������ٶ�ԶԶ�����������㣬��������ʽ�Ľ�����ǽ�����������Ϊ��������1.5����
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //��������� < ��С���� ������С������ֵ��������
            //��� oldCapacity=1���� minCapacity=1+1=2 newCapacity=1+(1>>1)=1
            if (newCapacity < minCapacity){
                newCapacity = minCapacity;
            }
            //����������
            Object[] objects = new Object[newCapacity];
            //�����ݸ��Ƶ�������
            System.arraycopy(elementData, 0, objects, 0, elementData.length);
            //�޸�����
            elementData = objects;
        }
    }

    public Object get(int index){
        //����Ƿ��±�Խ��
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException("�±�Խ��");
        }
    }

    public Object remove(int index){
        rangeCheck(index);
        //����Ԫ��
        Object oldValue = elementData[index];
        //�ҳ��û�����λ��
        int numMoved = size - index - 1;
        if (numMoved > 0){
            //��index+1��ʼ����ֵ����Ϊindex-numMoved��ֵ
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
