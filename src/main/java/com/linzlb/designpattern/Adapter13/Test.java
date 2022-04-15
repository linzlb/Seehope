package com.linzlb.designpattern.Adapter13;
//客户端
public class Test {
	public static void main(String[] args) {
        Target target = (Target) new Adapter(new Adaptee());
        target.adapteeMethod();
        target.adapterMethod();
    }
}
