package com.seehope.training.day1;

public class Chuanzhichuanzhi {
	float ptValue;

	public void changeInt(int value) {
		value = 55;
	}
	public void changeStr(String value) {
		value = new String("different");
		
	}
	public void changeObjValue(Chuanzhichuanzhi ref){
		ref.ptValue = 99;
	}

	public static void main(String[] args) {
		String str;
		int val;
		Chuanzhichuanzhi pt = new Chuanzhichuanzhi();

		val = 11;
		pt.changeInt(val);
		System.out.println("Int=" +val);

		str = new String("hello");
		pt.changeStr(str);
		System.out.println("Str=" +str);

		pt.ptValue = 101f;
		pt.changeObjValue(pt);
		System.out.println("ptValue=" +pt.ptValue);
	}
}