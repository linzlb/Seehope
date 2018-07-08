package day4.fugai;

public class Test {

	public static void main(String[] args) throws Exception{
		fun();
	}
	
	public static void fun(){
		// Animal是编译时类型
		// Cat是运行时类型
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		
		System.out.println(a1.getClass().getName()); //这种太精确了。
		
		if (a1 instanceof Cat) {
			System.out.println("a1是Cat类型");
		}
		if (a1 instanceof Animal) {
			System.out.println("a1是Animal类型");
		}
		a1.eat();
		a1.finaleat();
		a2.eat();
	}
	
	public static void fun2(Animal a){
		a.eat();
	}

	public static void fun3(){
		Animal animal = new Cat();
		animal.eat();
		//调用特殊方法时候要先强制转换为Cat类型
		((Cat)animal).shangshu();
	}
	
	public static void fun4() throws Exception{
		Class c = Class.forName("day4.fugai.Dog");
		Animal a = (Animal)c.newInstance();
		a.eat();
	}
}
