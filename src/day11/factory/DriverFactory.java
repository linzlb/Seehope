package day11.factory;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
	private static Map<String ,String> map = new HashMap();
	static{
		//全限定名
		map.put("dell", "day11.factory.DellDriver");
		map.put("apple", "day11.factory.AppleDriver");
		map.put("lenovo", "day11.factory.LenovoDriver");
		map.put("hp", "day11.factory.HPDriver");
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
