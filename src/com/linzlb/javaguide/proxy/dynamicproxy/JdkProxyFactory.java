package com.linzlb.javaguide.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * ��ȡ�������Ĺ���
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // Ŀ����������
                target.getClass().getInterfaces(),  // ������Ҫʵ�ֵĽӿڣ���ָ�����
                new DebugInvocationHandler(target)   // ��������Ӧ���Զ��� InvocationHandler
        );
    }
}
