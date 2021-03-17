package com.linzlb.designpattern.Mediator21;

public class ConcreteMediator extends Mediator {
    private ColleagueA ca;
    private ColleagueB cb;
    public ConcreteMediator() {
        ca = new ColleagueA();
        cb = new ColleagueB();
    }
    @Override
    public void notice(String content) {
        if (content.equals("boss")) {
            //老板来了, 通知员工A
        	System.out.println("老板来了, 通知员工A");
            ca.action();
        }
        if (content.equals("client")) {
            //客户来了,通知前台B
        	System.out.println("客户来了,通知前台B");
            cb.action();
        }
    }
}