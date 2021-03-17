package com.linzlb.designpattern.TemplateMethod07;
/*AbstractClass
定义抽象的原语操作（primitiveoperation），具体的子类将重定义它们以实现一个算法的各步骤。
实现一个模板方法,定义一个算法的骨架。
该模板方法不仅调用原语操作，也调用定义在AbstractClass或其他对象中的操作。*/
public abstract class Template {
	public abstract void print();
    public void update() {
        System.out.println("开始打印");
        for (int i = 0; i < 10; i++) {
            print();
        }
    }
}
