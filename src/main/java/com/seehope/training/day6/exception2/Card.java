package com.seehope.training.day6.exception2;

public class Card {
	private String id;
	private int balance;
	

	public int deposit(int money)throws CardException{
		if(money > 5000){
			throw new CardException("money>5000");
		}
		this.balance += money;
		return this.balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Card(String id, int balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
}
