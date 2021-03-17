package com.linzlb.designpattern.ChainOfResponsibility20.impl;

import com.linzlb.designpattern.ChainOfResponsibility20.AbstractRequest;
import com.linzlb.designpattern.ChainOfResponsibility20.Lever;

//具体请求类04
public class Request04 extends AbstractRequest {
	public Request04(String content) {  
        super(content);  
    }

	@Override
	public int getRequestLevel() {
		// TODO Auto-generated method stub
		return Lever.LEVEL_04;
		
	} 
}