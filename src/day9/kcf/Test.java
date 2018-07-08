package day9.kcf;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KFC kfc = new KFC();
		
		Productor p1 = new Productor("王超", kfc, "汉堡包");
		Productor p2 = new Productor("鲍宇超", kfc, "鸡腿");
		Productor p3 = new Productor("林政利", kfc, "可乐");
		consumer c1 = new consumer("吴悦湘", kfc);
		consumer c2 = new consumer("何世华", kfc);
		consumer c3 = new consumer("陈胜", kfc);
		
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}
	
}



class Productor extends Thread{
	private String foodName;
	private KFC kfc;
	public Productor(String name, KFC kfc, String foodName) {
		super(name);
		this.kfc = kfc;
		this.foodName = foodName;
	}

	public void run(){
		while(true){
			kfc.product(new Food(this.foodName));
			try {
				Thread.sleep(550);
			} catch (InterruptedException e) {
			}
		}
	}
}

class consumer extends Thread{
	private KFC kfc;
	
	public consumer(String name, KFC kfc) {
		super(name);
		this.kfc = kfc;
	}

	public void run(){
		while(true){
			this.kfc.consume();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
			}
		}
	}
}



