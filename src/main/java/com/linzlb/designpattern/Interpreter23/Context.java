package com.linzlb.designpattern.Interpreter23;

import java.util.ArrayList;
import java.util.List;

public class Context {
	private String content;
    private List list = new ArrayList();
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return this.content;
    }
    public void add(Expression eps) {
        list.add(eps);
    }
    public List getList() {
        return list;
    }
}
