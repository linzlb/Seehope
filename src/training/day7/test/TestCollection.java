package training.day7.test;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {  
    public static void main(String[] args)  
    {  
        Collection<String> c = new ArrayList<String>();  
        Collection<String> d = new ArrayList<String>();  
          
        c.add("1");  
        c.add("2");  
        c.add("1");  
        c.add("3");  
        c.add("1");  
        c.add("3");  
        c.add("3");  
        c.add("2");  
        c.add("3");  
          
        c.remove("3");  
          
        d.add("2");  
        d.add("1");  
        d.add("3");  
          
        System.out.println(c.equals(d));  
        System.out.println(c);  
        System.out.println(d);  
        System.out.println(c.hashCode());  
        System.out.println(d.hashCode());  
        System.out.println("----------------------");
        Object[] o = c.toArray();  
        String s = null;  
        for(int i = 0; i < o.length; i++)  
        {  
            s = (String)o[i];  
            System.out.print(s+"  ");  
        }  
        System.out.println();
        System.out.println(c.removeAll(d));  
        System.out.println(c);  
         
          
        
    }  
}  