package com.linzlb.designpattern.Decorator03;
//Decorator 维持一个执行Component对象的指针，并定义一个与Componect 接口一致的接口。
//装饰抽象类
public abstract class Decorator implements Person {
    protected Person person;
    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
    public void eat() {
        person.eat();
    }
}