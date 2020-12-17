package com.training.day5.inter2;

public class LenovoComputer extends Computer implements IUsb{
	private IUsb usb;
	
	public LenovoComputer(IUsb usb){
		super();
		this.usb = usb;
	}
	
	public void calculate(){
		System.out.println("���㡣������������");
		
	}
	public void usb(){
		//������ˣ�������������������������������
		this.usb.usb();
	}
}
