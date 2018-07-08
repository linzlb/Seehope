package day5.inter;

public class Test {
	public static void main(String[] args){
		Animal a = new JapeneseMan();
		//JapeneseMan a = new JapeneseMan();
		a.eat();
		IThief t = (IThief)a;
		t.thief();
		ICityManager m =(ICityManager)a;
		m.manager();
		
	}
}
