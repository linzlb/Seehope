package com.linzlb.designpattern.Visitor24.tongyonglizi;
//抽象元素类
/*定义一个accept操作，它以访问者为参数*/
public abstract class Element {
	 public abstract void accept(IVisitor visitor);  
	 public abstract void doSomething();  
}
