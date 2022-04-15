package com.linzlb.designpattern.gongchang05.impl;
/*
 * 定义工厂方法以返回一个ConcreteProduct实例
 */
import com.linzlb.designpattern.gongchang05.interface_.IWorkFactory;
import com.linzlb.designpattern.gongchang05.interface_.Work;

public class StudentWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new StudentWork();
	}

}
