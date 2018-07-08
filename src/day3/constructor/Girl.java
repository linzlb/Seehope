package day3.constructor;

public class Girl {
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//如果没有写构造方法，系统将提供一个默认的无参构造方法
	//系统提供的默认的无参数构造方法等价于以下这个构造方法
	/**
		public Girl(){
			
		}
	*/
	/*如果写了，系统将不再提供默认的构造方法,例如他提供了一个
	 * 有参构造方法
	 */
	public Girl(String name){
		this();
		this.name = name;
		System.out.println("Girl(String name)");
	}
	
	 //按规范手动提供一个无参构造方法
	public Girl(){
		//this("aaa");
		System.out.println("Girl()");
	}
	
}
