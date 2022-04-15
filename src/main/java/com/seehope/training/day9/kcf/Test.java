package com.seehope.training.day9.kcf;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KFC kfc = new KFC();
		
		Productor p1 = new Productor("����", kfc, "������");
		Productor p2 = new Productor("���", kfc, "����");
		Productor p3 = new Productor("������", kfc, "����");
		consumer c1 = new consumer("������", kfc);
		consumer c2 = new consumer("������", kfc);
		consumer c3 = new consumer("��ʤ", kfc);
		
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}
	
}



class Productor extends Thread{
	private String foodName;
	private KFC kfc;
	public Productor(String name, KFC kfc, String foodName) {
		super(name);
		this.kfc = kfc;
		this.foodName = foodName;
	}

	public void run(){
		while(true){
			kfc.product(new Food(this.foodName));
			try {
				Thread.sleep(550);
			} catch (InterruptedException e) {
			}
		}
	}
}

class consumer extends Thread{
	private KFC kfc;
	
	public consumer(String name, KFC kfc) {
		super(name);
		this.kfc = kfc;
	}

	public void run(){
		while(true){
			this.kfc.consume();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
			}
		}
	}
}



