package com.seehope.training.day7.map.pojo;

public class People {
	private String name;  
    private int age;  
      
    public People(String name,int age){  
        this.name = name;  
        this.age = age;  
    }  
      
    public String toString(){  
        return "name="+this.name+" age="+this.age;
    }  
}
