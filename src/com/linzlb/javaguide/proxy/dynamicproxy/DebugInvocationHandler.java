package com.linzlb.javaguide.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * jdk��̬������
 */
public class DebugInvocationHandler implements InvocationHandler {
    /**
     * �������е���ʵ����
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //���÷���֮ǰ�����ǿ�������Լ��Ĳ���
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //���÷���֮������ͬ����������Լ��Ĳ���
        System.out.println("after method " + method.getName());
        return result;
    }
}
