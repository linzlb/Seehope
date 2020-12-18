package com.linzlb.javaguide.proxy.staticproxy;

public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //���÷���֮ǰ�����ǿ�������Լ��Ĳ���
        System.out.println("before method send()");
        smsService.send(message);
        //���÷���֮������ͬ����������Լ��Ĳ���
        System.out.println("after method send()");
        return null;
    }
}
