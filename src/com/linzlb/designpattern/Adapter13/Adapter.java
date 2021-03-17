package com.linzlb.designpattern.Adapter13;
//通过内在的adaptee对象，把源接口转换为目标接口
public class Adapter implements Target{
	private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
	@Override
	public void adapteeMethod() {
		adaptee.adapteeMethod();
	}
	@Override
	public void adapterMethod() {
		System.out.println("Adapter method!");
    }
}
