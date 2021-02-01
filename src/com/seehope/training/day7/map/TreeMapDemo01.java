package com.seehope.training.day7.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new TreeMap<String,Integer>();  

        map.put("zhangsan", 1);
        map.put("zhangsan", 2);
        map.put("lisi", 3);
        map.put("wangwu", 5);
          
        System.out.println(map); 
	}

}
