package com.linzlb.multithread;

/**
 * 3. synchronized
 */
public class TraditionalThreadSynchronized {

	static class Output{
        //String xxx = "";
		public void output(String name){
			int len = name.length();
			/*for (int i = 0; i <len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();*/
			synchronized (Output.class) {
				for (int i = 0; i <len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public synchronized void output2(String name){
			int len = name.length();
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}

		public static synchronized void output3(String name){
			int len = name.length();
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}	
	}

	private void init(){
		final Output output = new Output();//�߳���ͬһ�����󲢼������ܱ�֤ͬ��
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				}

			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output3("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
				}
				
			}
		}).start();
	}

	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}
}