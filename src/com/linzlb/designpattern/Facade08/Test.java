package com.linzlb.designpattern.Facade08;

public class Test {
	public static void main(String[] args) {
		Car_Facade_Impl ref = new Car_Facade_Impl();
		ref.car_go_go(new Car());
	}
}
