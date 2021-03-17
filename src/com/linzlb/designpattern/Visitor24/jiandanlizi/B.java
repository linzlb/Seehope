package com.linzlb.designpattern.Visitor24.jiandanlizi;
//对于类A来说，类B就是一个访问者。但是这个例子并不是访问者模式的全部，虽然直观，但是它的可扩展性比较差
public class B {
	public void showA(A a){  
        a.method1();  
    }
}
