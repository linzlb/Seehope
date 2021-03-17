package com.linzlb.designpattern.Mediator21;

public class Test {
	public static void main(String[] args) {
        Mediator med = new ConcreteMediator();
        //老板来了
        med.notice("boss");
        System.out.println();
        //客户来了
        med.notice("client");
    }
}
