package com.linzlb.designpattern.Command19;
//Receiver知道如何实现与执行一个请求相关的操作。任何类都可能作为一个接收者。
public class Receiver {
	public void receive() {
        System.out.println("This is Receive class!");
    }
}
