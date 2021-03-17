package com.linzlb.designpattern.gongchang05.impl;

import com.linzlb.designpattern.gongchang05.interface_.Work;

/*
 * ConcreteProduct
 * 具体的产品，实现了Product接口
 */
public class StudentWork implements Work {
	@Override
	public void doWork() {
		System.out.println("学生做作业!");
	}

}
