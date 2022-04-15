package com.linzlb.designpattern.Proxy04;

public class Test {
	public static void main(String[] args) {
		Subject sub = new ProxyObject();
		sub.action();
	}
}
