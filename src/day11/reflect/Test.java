/*
 * UserId是私有的。
 */

package day11.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) 
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException{
		String s = new String("123");
		Test t = new Test();
		Class c = t.getClass();//获取某对象（活体）基因
		//利用基因名称得到基因描述
		Class c1 = Class.forName("java.lang.String");
		String s1 = (String) c1.newInstance();
		s1 = "abc";
		//---------类属性描述测试----------
		Class c2 = Class.forName("day11.reflect.User");
		Field[] fields = c2.getDeclaredFields();
		System.out.println("222222222222222222222222222222222");
		System.out.println(fields[0].getModifiers());
		System.out.println("222222222222222222222222222222222");
		//方法测试
		Method[] methods = c2.getDeclaredMethods();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(methods[0].getName() + "    " + methods[1].getName() + "    " + methods[2].getName()
				+ "    " + methods[3].getName() + "    " + methods[4].getName() + "    " + methods[5].getName());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		
		Method method = c2.getMethod("setUserId", int.class);
		//调用该方法
		Object o = c2.newInstance();
		method.invoke(o, 11111);//user.setUserId(1);
		
		User user = (User) o;
		
		
		System.out.println("................................");
		System.out.println(user.getUserId());
		System.out.println("................................");
	}
}
