package com.linzlb.designpattern.Composite15;

import java.util.List;

/*
 * Component 
 * 组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。
 * 声明一个接口用于访问和管理Component的子部件
 */
public abstract class Employer {
	private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public abstract void add(Employer employer);
    public abstract void delete(Employer employer);
    public List employers;
    public void printInfo() {
        System.out.println(name);
    }
    public List getEmployers() {
        return this.employers;
    }
}
