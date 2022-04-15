package com.linzlb.designpattern.ChainOfResponsibility20.impl;

import com.linzlb.designpattern.ChainOfResponsibility20.AbstractRequest;
import com.linzlb.designpattern.ChainOfResponsibility20.Lever;

//具体请求类02
public class Request02 extends AbstractRequest {
	public Request02(String content) {  
        super(content);  
    }

	@Override
	public int getRequestLevel() {
		// TODO Auto-generated method stub
		return Lever.LEVEL_02;
	} 
}
