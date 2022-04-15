package com.seehope.training.day5.inter2;

public class LenovoComputer extends Computer implements IUsb{
	private IUsb usb;
	
	public LenovoComputer(IUsb usb){
		super();
		this.usb = usb;
	}
	
	public void calculate(){
		System.out.println("calculate");
		
	}
	public void usb(){
		this.usb.usb();
	}
}
