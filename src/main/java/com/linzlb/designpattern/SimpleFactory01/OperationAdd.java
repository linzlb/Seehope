package com.linzlb.designpattern.SimpleFactory01;

public class OperationAdd implements Operation{

	@Override
	public int getResult(int a, int b) {
		int result = a + b;
		return result;
	}

}
