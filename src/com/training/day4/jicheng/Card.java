package com.training.day4.jicheng;

import java.util.Date;

/*
 * �����˻�
 */
public class Card {
	private String id ;
	private String passwd;
	private String name;
	private double balance;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static String getIdPre() {
		return ID_PRE;
	}

	
	
	private static final String ID_PRE = "HBS";
	
	public Card(){
		
	}
	public Card (String name,String passwd){
		super();
		this.id = this.createId();
		this.name = name;
		this.passwd = passwd;
	}
	public Card(String name, String passwd, double money){
		super();
		this.id = this.createId();
		this.name = name;
		this.passwd = passwd;
		this.balance = money;
	}
	
		
	private String createId(){
		//random() 0.0 <= x < 1.0
		return "HBS" + new Date().getTime()+(int)(Math.random()*1000);
	}
	
	/*-------------��Ϊ----------------*/
	
	public double deposit(double money){
		return 0 ;
		
	}
	
	public double withdraw(double money){
		return 0;
	}

}
