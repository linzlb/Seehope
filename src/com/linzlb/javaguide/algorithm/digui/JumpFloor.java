package com.linzlb.javaguide.algorithm.digui;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/1/27 17:20
 * @Function:Fibonacci,��̨������
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������������n��̨���ܹ��м���������
 * ������
 * �����2��������1�׻�2�ף�
 *  1����һ����1�ף�������f(n-1)
 *  2����һ����2�ף�������f(n-2)
 * ������������f(n)=f(n-1)+f(n-2) ,f(1)=1,f(2)=2
 */
public class JumpFloor {
    //�����ݹ顫 ȱ���ǻ��ظ����㣬����ʱ�临�Ӷ������������*��������Ҫ��ʱ��=O(2^n)
    public static int jumpFloor(int number){
        if (number <= 0){
            return 0;
        }else if (number == 1){
            return 1;
        }else if (number == 2){
            return 2;
        }
        return jumpFloor(number-2)+jumpFloor(number-1);
    }

    //�ݹ�Ч�ʵͣ��õ����Ż���
    //ʵ���Ͼ���dp table��˼�루ѭ������+����¼���Ե����������ƣ������˵ݹ飬ʱ�临�Ӷ�O(N)��
    public static int jumpFloor2(int number){
        if (number <= 0){
            return 0;
        }else if (number == 1){
            return 1;
        }else if (number == 2){
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= number; i++){
            third = first+second;
            first = second;
            second = third;
        }
        return third;
    }

    //��̬��̨������
    //һֻ?һ�ο�������1��̨�ף�Ҳ��������2����Ҳ��������n������?����n��̨���ܹ��м���������
    //��n>2��ʱ��f(n)=f(n-1)+f(n-2)+...+f(1)=2^(n-1)
    public int jumpFloor3(int number){
        //2^(n-1) ��λ�Ʋ���������
        return 1<<--number;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(20));
        System.out.println(jumpFloor2(20));
    }
}
