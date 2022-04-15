package com.linzlb.designpattern.Command19;
//ConcreteCommand将一个接收者对象绑定于一个动作。
//调用接收者相应的操作，以实现Execute。
public class CommandImpl extends Command {
    public CommandImpl(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void execute() {
        receiver. receive ();
    }
}