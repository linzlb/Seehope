package com.linzlb.designpattern.Strategy02;
/*ConcreteStrategy
以Strategy接口实现某具体算法*/
public class StrategyImplA extends Strategy {
    public void method() {
        System.out.println("这是第1个实现");
    }
}