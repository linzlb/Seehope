package com.training.day7.myStack;

import java.util.LinkedList;

public class MyQueue {
	private LinkedList list = new LinkedList();
	public MyQueue(){
		
	}
	
	public Object peek() {
		return list.peekFirst();
	}
	
	public Object pop(){
		/*if (list.size()==0) return null;
	    Object o= list.get(list.size()-1);
	    list.remove(list.size()-1);
	    return o;*/
		Object o = list.peekLast();
		list.remove(list.peekLast());
		return o;
	}
	
	public Object push(Object o) {
		list.addFirst(o);
		return o;
	}
	
	public int size(){
		return list.size();
	}
}
