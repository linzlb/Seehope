package com.linzlb.javaguide.proxy.dynamicproxy;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/18 10:31
 * @Function:JDK
��̬����� CGLIB ��̬����Ա�
JDK ��̬����ֻ��ֻ�ܴ���ʵ���˽ӿڵ��࣬�� CGLIB ���Դ���δʵ���κνӿڵ��ࡣ ���⣬ CGLIB ��̬������ͨ������һ��������������������ر�������ķ������ã���˲��ܴ�������Ϊ final ���͵���ͷ�����
�Ͷ��ߵ�Ч����˵���󲿷�������� JDK ��̬��������㣬���� JDK �汾��������������Ƹ������ԡ�
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
