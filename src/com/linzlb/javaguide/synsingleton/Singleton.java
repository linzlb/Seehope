package com.linzlb.javaguide.synsingleton;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/18 14:30
 * @Function:˫��У����ʵ�ֶ��������̰߳�ȫ��
 */
public class Singleton {

    /*
    uniqueInstance ���� volatile �ؼ�������Ҳ�Ǻ��б�Ҫ�ģ�
    uniqueInstance = new Singleton(); ��δ�����ʵ�Ƿ�Ϊ����ִ�У�
    Ϊ uniqueInstance �����ڴ�ռ�
    ��ʼ�� uniqueInstance
    �� uniqueInstance ָ�������ڴ��ַ
    ��������jvm����ָ�����ŵ����ԣ�ִ��˳���п��ܱ�� 1->3->2��
    ָ�������ڵ��̻߳����²���������⣬�����ڶ��̻߳����»ᵼ��һ���̻߳�û�û�г�ʼ����ʵ����
    ���磬�߳� T1 ִ���� 1 �� 3����ʱ T2 ���� getUniqueInstance() ���� uniqueInstance ��Ϊ�գ�
    ��˷��� uniqueInstance������ʱ uniqueInstance ��δ����ʼ����
    ʹ�� volatile ���Խ�ֹjvm��ָ�����ţ���֤�ڶ��̻߳�����Ҳ���������С�
     */
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public  static Singleton getUniqueInstance() {
        //���ж϶����Ƿ��Ѿ�ʵ������û��ʵ�������Ž����������
        if (uniqueInstance == null) {
            //��������
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
