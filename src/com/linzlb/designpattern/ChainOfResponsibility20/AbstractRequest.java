package com.linzlb.designpattern.ChainOfResponsibility20;
//请求抽象类
public  abstract class AbstractRequest  {
	 private String content = null;  
	 
	    public AbstractRequest(String content) {  
	        this.content = content;  
	    }  
	 
	    public String getContent() {  
	        return this.content;  
	    }  
	 
	    // 获得请求的级别  
	    public abstract int getRequestLevel();
}
