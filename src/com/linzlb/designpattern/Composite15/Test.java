package com.linzlb.designpattern.Composite15;

import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Employer p1 = new Projectmanager("项目经理1");
		Employer p2 = new Projectmanager("项目经理2");
		Employer programmer1 = new Programmer("程序员1");
		Employer programmer2 = new Programmer("程序员2");
		Employer programmer3 = new Programmer("程序员3");
		p2.add(programmer2);
        p2.add(programmer3);
        p1.add(p2);//为项目经理添加项目助理
        p1.add(programmer1);//为项目经理添加程序员
        
        List empList = p1.getEmployers();
        System.out.println("项目经理1下面的员工有：");
        for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employer e = (Employer) iterator.next();
			System.out.println(e.getName());
		}
        System.out.println();
        System.out.println("项目经理2下面的员工有：");
        List empList2 = p2.getEmployers();
        for (Iterator iterator = empList2.iterator(); iterator.hasNext();) {
			Employer e = (Employer) iterator.next();
			System.out.println(e.getName());
		}
    }
}
