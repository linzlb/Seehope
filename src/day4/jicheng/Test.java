package day4.jicheng;

public class Test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCard card = new CreditCard("meten","meten123", 100000);
		System.out.println("balance:"+card.getBalance());
		System.out.println("creitBalance:"+card.getCreditBalance());
		System.out.println("name:"+card.getName());
		System.out.println("passwd:"+card.getPasswd());
		System.out.println("class:"+card.getClass());
		System.out.println("id:"+card.getId());

	}

}
