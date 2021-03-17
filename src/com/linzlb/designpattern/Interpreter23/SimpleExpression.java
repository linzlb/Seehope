package com.linzlb.designpattern.Interpreter23;
public class SimpleExpression extends Expression {
    void interpret(Context ctx) {
        System.out.println("这是普通解析器!");
    }
}