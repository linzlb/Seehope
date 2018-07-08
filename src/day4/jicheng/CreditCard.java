package day4.jicheng;

public class CreditCard extends Card{
	private double creditBalance;
	
	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	public CreditCard(){
		
	}
	
	public CreditCard(String name, String passwd, double money){
		super(name, passwd);
		this.creditBalance = money;
	}
	

}
