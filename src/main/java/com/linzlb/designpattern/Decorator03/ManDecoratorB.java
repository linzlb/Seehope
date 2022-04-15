package com.linzlb.designpattern.Decorator03;
/*
 * ConcreteDectrator 
 * 向组件添加职责
 */
public class ManDecoratorB extends Decorator {
    @Override
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类,eat");
    }
}