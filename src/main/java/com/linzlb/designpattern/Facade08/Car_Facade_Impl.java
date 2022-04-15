package com.linzlb.designpattern.Facade08;

public class Car_Facade_Impl {
	
	public void car_go_go(Car car_ref){
		car_ref.check_box();
		car_ref.check_console();
		car_ref.check_stop();
		car_ref.start();
	}

}
