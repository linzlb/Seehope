package com.linzlb.designpattern.Command19;
//Invoker要求该命令执行这个请求。
public class Invoker {
	 private Command command;
	    public void setCommand(Command command) {
	        this.command = command;
	    }
	    public void execute() {
	        command.execute();
	    }
}
