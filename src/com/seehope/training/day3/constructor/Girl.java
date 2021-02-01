package com.seehope.training.day3.constructor;

public class Girl {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
		public Girl(){
			
		}
	*/

	public Girl(String name){
		this();
		this.name = name;
		System.out.println("Girl(String name)");
	}

	public Girl(){
		//this("aaa");
		System.out.println("Girl()");
	}
	
}
