package com.linzlb.designpattern.Iterator16;

public class Test {
	public static void main(String[] args) {
        List list = new ListImpl();
        list.add("a");
        list.add("b");
        list.add("c");
        //第一种迭代方式
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("=====");
        //第二种迭代方式
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}
