package com.seehope.training.day5.inter2;

public class Test {

	public static void main(String[] args) {
		IUsb m = new MouseBiao();
		IUsb p = new Phone();
		IUsb c = new LenovoComputer(p);
		m.usb();
		p.usb();
		c.usb();
		
		Computer c2 = (Computer) c;
		c2.calculate();
	}

}
