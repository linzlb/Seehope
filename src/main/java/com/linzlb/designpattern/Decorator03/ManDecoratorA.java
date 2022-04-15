package com.linzlb.designpattern.Decorator03;
/*
 * ConcreteDectrator 
 * 向组件添加职责
 */
public class ManDecoratorA extends Decorator {
    @Override
    public void eat() {
    	System.out.println("ManDecoratorA类eat()");
        super.eat();
        reEat();    
    }
    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}