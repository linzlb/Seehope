package day9.kcf;

import java.util.LinkedList;

public class HuoJia {
	public static int MAX_SIZE = 10;
	private LinkedList<Food> ll = new LinkedList<Food>();
	@Override
	public String toString() {
		return this.ll.toString()+"----共"+this.ll.size()+"个食物";
	}
	
	public void add(Food f) {
		this.ll.addLast(f);
	}
	
	public Food poll() {
		return this.ll.removeFirst();
	}
	
	public int size() {
		return ll.size();
	}
}
