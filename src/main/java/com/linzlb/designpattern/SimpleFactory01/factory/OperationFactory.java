package com.linzlb.designpattern.SimpleFactory01.factory;

import com.linzlb.designpattern.SimpleFactory01.*;

//后续改进！！！如果是使用反射去拿的话，那么以后就再也不用修改工厂了。
public class OperationFactory {
	public static Operation createOperate(String operate){
		if(operate == "+"){
			return new OperationAdd();
		}
		if(operate == "-"){
			return new OperationSub();
		}
		if(operate == "*"){
			return new OperationMul();
		}
		if(operate == "/"){
			return new OperationDiv();
		}
		return null;
	}
}
