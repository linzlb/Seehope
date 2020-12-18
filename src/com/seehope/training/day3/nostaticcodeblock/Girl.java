package com.seehope.training.day3.nostaticcodeblock;

public class Girl {
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Girl(){
		System.out.println("���췽��������");
	}
	
	{
		System.out.println("��̬����顣����");
		
	}
}
