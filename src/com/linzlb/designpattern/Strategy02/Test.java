package com.linzlb.designpattern.Strategy02;

public class Test {
	public static void main(String[] args) {
        Context ctx = new Context(new StrategyImplA());
        ctx.doMethod();
        ctx = new Context(new StrategyImplB());
        ctx.doMethod();
        ctx = new Context(new StrategyImplC());
        ctx.doMethod();
    }
}
