package day5.abs2;

public class Test {


	public static void main(String[] args) {
	
		printArea(new Circle(3.0));

	}
	public static void printArea(Shape s){
		System.out.println(s.calculateArea());
		
	}

}
