package day9.thread;

public class TestThread3 {

	public static void main(String[] args) {
		BlackBoard b = new BlackBoard();
		Linda linda = new Linda(b);
		Meten meten = new Meten(b);

		meten.start();
		linda.start();
	}

}

class BlackBoard {
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/*
	 * public void printMessage(String message) { synchronized (this) {
	 * this.setMessage(message);
	 * System.out.println(Thread.currentThread().getName() + "说:" +
	 * this.getMessage()); } }
	 */
	public void printMessage(String message) {

		if (Thread.currentThread().getName().equals("Meten")) {
			System.out.println("meten上大厕...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("linda上大厕...");
		}

		synchronized (this) {
			this.setMessage(message);
			System.out.println(Thread.currentThread().getName() + "说:"
					+ this.getMessage());
		}

	}
	/*
	 * public void printMessage(String message) { this.setMessage(message);
	 * System.out.println(Thread.currentThread().getName() + "说:" +
	 * this.getMessage());
	 * 
	 * }
	 */
	/*
	 * public void printMessage(String message) { synchronized (this.message) {
	 * this.setMessage(message);
	 * System.out.println(Thread.currentThread().getName() + "说:" +
	 * this.getMessage()); }
	 */

}

class Linda extends Thread {
	private BlackBoard b;

	public Linda(BlackBoard b) {
		super("Linda");
		this.b = b;
	}

	public void run() {
		// synchronized(this.b){
		this.b.printMessage("6.1放假");
		// }
	}
}

class Meten extends Thread {
	private BlackBoard b;

	public Meten(BlackBoard b) {
		super("Meten");
		this.b = b;
	}

	public void run() {
		// synchronized(this.b){
		this.b.printMessage("5.31放假");
		// }
	}
}