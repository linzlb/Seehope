package com.training.day7.myStack;

import java.util.LinkedList;

public class MyStack {
	private LinkedList list = new LinkedList();

	public MyStack(){
		
	}
	
	public Object peek() {
		return list.peekFirst();
	}
	
	public Object pop(){
		return list.pop();
		
	}
	
	public Object push(Object o) {
		list.addFirst(o);
		return o;
	}
	
	public int size(){
		return list.size();
	}
}
