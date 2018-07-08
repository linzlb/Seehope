package day5.single2;

public class Star {
	private static Star[] star = new Star[3];
	
	private Star(){
		
	}
	public void action(){
		
	}
	public static Star getInstance(int type){
		switch (type) {
		case 0:
			if(null == star[type]){
				star[type] = new Earth();
			}
			return star[type];
		case 1:
			if(null == star[type]){
				star[type] =  new Sun();
			}
			return star[type];
		case 2:
			if(null == star[type]){
				star[type] =  new Moon();
			}
			return star[type];
		default:
			if(null == star[0]){
				star[0] =  new Earth();
			}
			return star[0];
		}
	}
	

	public static class Earth extends Star {
		public void action(){
			System.out.println("适合人类居住");
		}
	}

	public static class Sun extends Star {
		public void action(){
			System.out.println("供给人类能源");
		}
	}

	public static class Moon extends Star {
		public void action(){
			System.out.println("供人类观赏嫦娥");
		}
	}
	
}
