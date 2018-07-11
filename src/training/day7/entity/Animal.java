package training.day7.entity;


public class Animal implements training.day7.entity.Comparable {
	private String name;
	private int score;
	
	@Override
	public int compareTo(Object o) {
		Animal s = (Animal)o;
		return this.score - s.score;
	}
	
	
	@Override
	public int hashCode() {
		System.out.println("hashCode...(Animal.java�����)");
		return this.name.hashCode() ^ this.score;
	}


	@Override
	public boolean equals(Object obj) {
		System.out.println("equals...");
		if(this == obj){
			return true;
		}
		
		if(!obj.getClass().getName().equals(this.getClass().getName())){
			return false;
		}
		
		Animal s = (Animal)obj;
		if(s.getName().equals(this.name) && s.getScore() == this.score){
			return true;
		}
		
		return false;
	}


	public String toString(){
		return this.name+":"+score;
	}
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
