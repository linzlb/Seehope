package day6.exception2;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Card c = new Card("1",1000);
		try {
			c.deposit(50000);
		} catch (CardException e) {
			e.printStackTrace();
			System.out.println("�쳣��Ϣ:"+e.getMessage());
		}
	}

}