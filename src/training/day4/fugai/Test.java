package training.day4.fugai;

public class Test {

	public static void main(String[] args) throws Exception{
		fun();
	}
	
	public static void fun(){
		// Animal�Ǳ���ʱ����
		// Cat������ʱ����
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		
		System.out.println(a1.getClass().getName()); //����̫��ȷ�ˡ�
		
		if (a1 instanceof Cat) {
			System.out.println("a1��Cat����");
		}
		if (a1 instanceof Animal) {
			System.out.println("a1��Animal����");
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
		//�������ⷽ��ʱ��Ҫ��ǿ��ת��ΪCat����
		((Cat)animal).shangshu();
	}
	
	public static void fun4() throws Exception{
		Class c = Class.forName("training.day4.fugai.Dog");
		Animal a = (Animal)c.newInstance();
		a.eat();
	}
}
