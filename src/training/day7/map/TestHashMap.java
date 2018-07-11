package training.day7.map;


import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import training.day7.entity.Student;

public class TestHashMap {
	
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("1", new Student("meten",30));
		hm.put("2", new Student("janet", 500));
		hm.put("3", new Student("eric",300));
		hm.put("4", new Student("kacy", 5100));
		hm.put("5", new Student("naric",330));
		hm.put("6", new Student("linda", 510));
		hm.put("1", new Student("ee",1000));
		//ͨ��key��ȡֵ
		System.out.println("key=5,value="+hm.get("5"));
		System.out.println();
		
		//����key��ȡֵ
		Set keys = hm.keySet();
		for(Object key : keys){
			System.out.println(key +"-"+hm.get(key));
		}
		System.out.println();
		//ֱ�ӱ���ֵ
		Collection values = hm.values();
		for(Object value : values){
			System.out.println(value);
		}
	}

}
