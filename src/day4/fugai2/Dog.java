package day4.fugai2;

public class Dog extends Animal{

	public String name = "dog";
	public Bone eat(){
		System.out.println("³Ô¹ÇÍ·");
		return new Bone();
	}
}
