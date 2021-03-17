package com.linzlb.designpattern.Composite15;
//叶子节点
public class ProcectAssistant extends Employer {

   public ProcectAssistant(String name) {
	   setName(name);
       employers = null;//项目助理, 表示没有下属了
   }
   public void add(Employer employer) {
   }
    public void delete(Employer employer) {
   }
}