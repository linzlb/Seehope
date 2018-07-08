package day3.fengzhuang;

public class Girl {
	//凡是被private修饰的属性和方法
	//仅能在本类使用
	//protected String name;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public void say(String name){
		if ("zhengli".equals(name)){
			this.thinkIdea();
			//System.out.println(this.name);
		}else{
			System.out.println("你猜");
		}
	}
	
	private void thinkIdea(){
		System.out.println("HI, 我的名字叫"+this.name+"!我的想法.");
	}
}
