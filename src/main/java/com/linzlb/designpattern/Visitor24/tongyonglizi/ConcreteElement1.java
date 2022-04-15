package com.linzlb.designpattern.Visitor24.tongyonglizi;

public class ConcreteElement1 extends Element {  
    public void doSomething(){  
        System.out.println("这是元素1");  
    }  
      
    public void accept(IVisitor visitor) {  
        visitor.visit(this);  
    }  
}  