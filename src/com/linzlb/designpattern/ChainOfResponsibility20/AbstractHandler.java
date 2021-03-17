package com.linzlb.designpattern.ChainOfResponsibility20;
//抽象处理类
public abstract class AbstractHandler {
	// 责任链的下一个节点，即处理者  
    private AbstractHandler nextHandler = null;  
 
    // 捕获具体请求并进行处理，或是将请求传递到责任链的下一级别  
    public final void handleRequest(AbstractRequest request) {  
 
        // 若该请求与当前处理者的级别层次相对应，则由自己进行处理  
        if (this.getHandlerLevel() == request.getRequestLevel()) {  
            this.handle(request);  
        } else {  
            // 当前处理者不能胜任，则传递至职责链的下一节点  
            if (this.nextHandler != null) {  
                System.out.println("当前 处理者-0" + this.getHandlerLevel()  
                        + " 不足以处理 请求-0" + request.getRequestLevel());  
                  
                // 这里使用了递归调用  
                this.nextHandler.handleRequest(request);  
            } else {  
                System.out.println("职责链上的所有处理者都不能胜任该请求...");  
            }  
        }  
    }  
 
    // 设置责任链中的下一个处理者  
    public void setNextHandler(AbstractHandler nextHandler) {  
        this.nextHandler = nextHandler;  
    }  
 
    // 获取当前处理者的级别  
    protected abstract int getHandlerLevel();  
 
    // 定义链中每个处理者具体的处理方式  
    protected abstract void handle(AbstractRequest request);  
}
