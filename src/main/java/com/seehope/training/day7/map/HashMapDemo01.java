package com.seehope.training.day7.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.seehope.training.day7.map.pojo.People;

public class HashMapDemo01 {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();  
        map.put("zhangsan", 1);  
        map.put("zhangsan", 2);  
        map.put("lisi", 3);  
        map.put("wangwu", 5);  
        System.out.println(map);  
        System.out.println("---------------------------------------");
        Integer value = map.get("zhangsan");     
        System.out.println(value);  
        System.out.println("---------------------------------------");
        Set<String> s = map.keySet();  
        Iterator<String> ite = s.iterator();  
        while (ite.hasNext()){  
            System.out.println(ite.next());  
        }  
        System.out.println("---------------------------------------");
        Set<String> setall = map.keySet();  
        Iterator<String> ite2 = setall.iterator();  
        while (ite2.hasNext()){  
            String str = ite2.next();  
            System.out.println(str + "-->"+map.get(str));  //str��key
        }  
        
        System.out.println("����������������������������������������������������������������");
        Set <Map.Entry<String,Integer>> setmap = map.entrySet();  
        Iterator<Map.Entry<String,Integer>> ite3 = setmap.iterator();    
        while (ite3.hasNext()){  
            Map.Entry<String,Integer> myent = ite3.next();  
            System.out.println(myent.getKey()+"-->"+myent.getValue());  
        }  
        System.out.println("---------------------------------------");
        //jdk1.5
        for (Map.Entry<String, Integer> my:map.entrySet()){  
            System.out.println(my.getKey()+"-->"+my.getValue());  
        } 
        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        Map<String,People> map2 = new HashMap<String,People>();
        map2.put("zf", new People("linlin",30));
        System.out.println(map2); 
        System.out.println(map2.get("zf"));  
        System.out.println(map2.get(new String("zf"))); 
        System.out.println("---------------------------------------");
        Map<People,String> map3 = new IdentityHashMap<People,String>();     
        map3.put(new People("xiecuiwen",30),"zf" );
        map3.put(new People("linzlb",30),"zf" );
        System.out.println(map3);    
	}

}
