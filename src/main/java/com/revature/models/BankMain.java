package com.revature.models;

public class BankMain {

	public static void main(String[] args) {
		
		BankTransaction cust1 = new BankTransaction();
		cust1.deposit(0);
		
		BankTransaction cust3 = new BankTransaction();
		cust3.deposit(0);
		
		System.out.println(cust1.getBalance());
		System.out.println(cust3.getBalance());

	}

}
