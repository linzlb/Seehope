package com.training.day11.factory;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
	private static Map<String ,String> map = new HashMap();
	static{
		//ȫ�޶���
		map.put("dell", "DellDriver");
		map.put("apple", "AppleDriver");
		map.put("lenovo", "LenovoDriver");
		map.put("hp", "HPDriver");
	}
	
	public static  Driver createDriver(String driverName) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Driver d = null;
		Class c = Class.forName(map.get(driverName));
		d = (Driver) c.newInstance();
		
		
//		if("dell".equals(driverName)){
//			d  =new  DellDriver();
//		}else if("apple".equals(driverName)){
//			d = new AppleDriver();
//		}else if("lenovo".equals(driverName)){
//			d = new LenovoDriver();
//		}
		return d;
	}
}
