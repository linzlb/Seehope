package com.linzlb.designpattern.Observer10;

import java.util.ArrayList;
import java.util.List;
/*
 * Subject（目标）
          目标知道它的观察者。可以有任意多个观察者观察同一个目标。
         提供注册和删除观察者对象的接口。
 */
public abstract class Citizen {
	List pols;
    String help = "normal";
    public void setHelp(String help) {
        this.help = help;
    }
    public String getHelp() {
        return this.help;
    }

    public void setPolicemen() {
        this.pols = new ArrayList();
    }
    public void register(Policeman pol) {
        this.pols.add(pol);
    }
    public void unRegister(Policeman pol) {
        this.pols.remove(pol);
    }
    
    
    abstract void sendMessage(String help);
}
