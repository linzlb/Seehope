package com.linzlb.designpattern.Decorator03;

public class Test {
	public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();
        md1.setPerson(man);
        md2.setPerson(md1);
        //md2.setPerson(man);
        md2.eat();
    }
}
