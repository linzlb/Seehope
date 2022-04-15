package com.linzlb.designpattern.Prototype06;

public class Test {
	public static void main(String[] args) {
        Prototype pro = new ConcretePrototype("林政利");
        Prototype pro2 = (Prototype)pro.clone();
        Prototype pro3 = (Prototype)pro.clone();
        System.out.println("3份的名字：");
        System.out.println(pro.getName());
        System.out.println(pro2.getName());
        System.out.println(pro3.getName());
        System.out.println("3份的地址：");
        System.out.println(pro);
        System.out.println(pro2);
        System.out.println(pro3);
    }
}
