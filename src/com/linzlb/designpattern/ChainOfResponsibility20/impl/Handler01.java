package com.linzlb.designpattern.ChainOfResponsibility20.impl;


import com.linzlb.designpattern.ChainOfResponsibility20.AbstractHandler;
import com.linzlb.designpattern.ChainOfResponsibility20.AbstractRequest;
import com.linzlb.designpattern.ChainOfResponsibility20.Lever;

//具体处理者-01
public class Handler01 extends AbstractHandler {

	@Override
	protected int getHandlerLevel() {
		// TODO Auto-generated method stub
		return Lever.LEVEL_01;
	}

	@Override
	protected void handle(AbstractRequest request) {
		// TODO Auto-generated method stub
		System.out.println("处理者-01 处理 " + request.getContent() + "\n");  
	}  
}  