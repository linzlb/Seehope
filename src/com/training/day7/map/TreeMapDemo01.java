package com.training.day7.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new TreeMap<String,Integer>();  
        //�ᰴ��key����
        map.put("A��zhangsan", 1);  
        map.put("A��zhangsan", 2);  
        map.put("C��lisi", 3);  
        map.put("B��wangwu", 5);  
          
        System.out.println(map); 
	}

}
