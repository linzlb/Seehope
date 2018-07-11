
package training.day9.kcf;

public class KFC {
	private HuoJia hj = new HuoJia();
	
	public void consume() {
		synchronized(this.hj) {
			hj.notifyAll();
			//hj.notify();
			while(hj.size() == 0){//������if�����if��Ԓ����l���ˮ��������N���^�m����������Z��,,����Ϊ�յ�ʱ��ȴ�
				try {
					hj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Food f = this.hj.poll();
			String name = Thread.currentThread().getName();
			System.out.println(name+"����һ��"+f);
			System.out.println("��ǰ�����������:");
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
			System.out.println(name+"������һ��"+f);
			System.out.println("��ǰ�����������:");
			System.out.println(this.hj);
		}
	}
}
