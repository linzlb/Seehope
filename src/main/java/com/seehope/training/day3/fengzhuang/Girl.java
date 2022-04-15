package com.seehope.training.day3.fengzhuang;

public class Girl {

	//protected String name;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public void say(String name){
		if ("zhengli".equals(name)){
			this.thinkIdea();
			//System.out.println(this.name);
		}else{
			System.out.println("���");
		}
	}
	
	private void thinkIdea(){
		System.out.println("HI, "+this.name+"!");
	}
}
