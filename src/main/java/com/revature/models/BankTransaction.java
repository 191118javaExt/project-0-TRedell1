package com.revature.models;

public class BankTransaction {
	
	int banktransaction_id;
	int bankaccount_id;
	//int balance;
	//int previousTransaction;
	//String customerName;
	String bankuser_id;
	float amount;
	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBanktransaction_id() {
		return banktransaction_id;
	}
	public void setBanktransaction_id(int banktransaction_id) {
		this.banktransaction_id = banktransaction_id;
	}
	public int getBankaccount_id() {
		return bankaccount_id;
	}
	public void setBankaccount_id(int bankaccount_id) {
		this.bankaccount_id = bankaccount_id;
	}
	public String getBankuser_id() {
		return bankuser_id;
	}
	public void setBankuser_id(String bankuser_id) {
		this.bankuser_id = bankuser_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + bankaccount_id;
		result = prime * result + banktransaction_id;
		result = prime * result + ((bankuser_id == null) ? 0 : bankuser_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankTransaction other = (BankTransaction) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (bankaccount_id != other.bankaccount_id)
			return false;
		if (banktransaction_id != other.banktransaction_id)
			return false;
		if (bankuser_id == null) {
			if (other.bankuser_id != null)
				return false;
		} else if (!bankuser_id.equals(other.bankuser_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BankTransaction [banktransaction_id=" + banktransaction_id + ", bankaccount_id=" + bankaccount_id
				+ ", bankuser_id=" + bankuser_id + ", amount=" + amount + "]";
	}
	public BankTransaction(int banktransaction_id, int bankaccount_id, String bankuser_id, float amount) {
		super();
		this.banktransaction_id = banktransaction_id;
		this.bankaccount_id = bankaccount_id;
		this.bankuser_id = bankuser_id;
		this.amount = amount;
	}
	
	private double balance;
	
		public void BankAccount() {
			balance = 0.0; 
		}
		
		public void deposit(double amount) {
			balance = balance + amount;
		}
		
		public void withdraw(double amount) {
			balance = balance - amount;
		}
		
		public double getBalance() {
			return balance; 
		}
	
}