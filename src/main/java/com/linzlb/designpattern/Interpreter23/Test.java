package com.linzlb.designpattern.Interpreter23;

import java.util.Iterator;
import java.util.List;



public class Test {
	public static void main(String[] args) {
        Context ctx = new Context();
        ctx.add(new SimpleExpression());
        ctx.add(new AdvanceExpression());
        ctx.add(new SimpleExpression());
        List l = ctx.getList();
        //System.out.println(l.size());
        for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Expression expression = (Expression) iterator.next();
			expression.interpret(ctx);
		}

    }
}
