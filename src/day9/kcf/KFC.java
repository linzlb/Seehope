
package day9.kcf;

public class KFC {
	private HuoJia hj = new HuoJia();
	
	public void consume() {
		synchronized(this.hj) {
			hj.notifyAll();
			//hj.notify();
			while(hj.size() == 0){//不能用if，因為if的話如果發生了異常，那麼會繼續執行後面的語句,,货架为空的时候等待
				try {
					hj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Food f = this.hj.poll();
			String name = Thread.currentThread().getName();
			System.out.println(name+"吃了一个"+f);
			System.out.println("当前货架情况如下:");
			System.out.println(this.hj);
		}
		
	}
	
	public void product(Food f) {
		synchronized(this.hj) {
			hj.notify();
			while(hj.size() == hj.MAX_SIZE) {
				try {
					hj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.hj.add(f);
			String name = Thread.currentThread().getName();
			System.out.println(name+"生产了一个"+f);
			System.out.println("当前货架情况如下:");
			System.out.println(this.hj);
		}
	}
}
