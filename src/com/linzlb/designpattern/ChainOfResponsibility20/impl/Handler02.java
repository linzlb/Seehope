package com.linzlb.designpattern.ChainOfResponsibility20.impl;

import com.linzlb.designpattern.ChainOfResponsibility20.AbstractHandler;
import com.linzlb.designpattern.ChainOfResponsibility20.AbstractRequest;
import com.linzlb.designpattern.ChainOfResponsibility20.Lever;

//具体处理者-02
public class Handler02 extends AbstractHandler {

	@Override
	protected int getHandlerLevel() {
		// TODO Auto-generated method stub
		return Lever.LEVEL_02;
	}

	@Override
	protected void handle(AbstractRequest request) {
		// TODO Auto-generated method stub
		System.out.println("处理者-02 处理 " + request.getContent() + "\n");  
	}  
}  