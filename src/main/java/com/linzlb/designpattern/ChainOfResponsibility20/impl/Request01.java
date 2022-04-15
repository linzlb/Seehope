package com.linzlb.designpattern.ChainOfResponsibility20.impl;

import com.linzlb.designpattern.ChainOfResponsibility20.AbstractRequest;
import com.linzlb.designpattern.ChainOfResponsibility20.Lever;

//具体请求类01
public class Request01 extends AbstractRequest {
	public Request01(String content) {  
        super(content);  
    }

	@Override
	public int getRequestLevel() {
		// TODO Auto-generated method stub
		return Lever.LEVEL_01;
	}  
 
    
}
