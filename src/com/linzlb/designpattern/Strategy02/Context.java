package com.linzlb.designpattern.Strategy02;
/*Context上下文
用一个ConcreteStrategy对象来配置。
维护一个对Strategy对象的引用。
可定义一个接口来让Stategy访问它的数据。*/
public class Context {
	Strategy stra;
    public Context(Strategy stra) {
        this.stra = stra;
    }
    public void doMethod() {
        stra.method();
    }
}	
