package com.seehope.training.day7.entity;

public interface Comparable {
	//0,this.getAge == o.getAge()
	//+n,this.getAge > o.getAge()
	//-n,this.getAge < o.getAge()
	
	

	public int compareTo(Object o);
}
