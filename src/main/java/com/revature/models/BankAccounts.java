package com.revature.models;

public class BankAccounts {

		int bankacount_id;
		String account_type;
		int bankuser_id;
		Float balance;
		String account_open;
		
		public BankAccounts() {
			super();
			// TODO Auto-generated constructor stub
		}

		public BankAccounts(int bankacount_id, String account_type, int bankuser_id, Float balance,
				String account_open) {
			super();
			this.bankacount_id = bankacount_id;
			this.account_type = account_type;
			this.bankuser_id = bankuser_id;
			this.balance = balance;
			this.account_open = account_open;
		}

		public int getBankacount_id() {
			return bankacount_id;
		}

		public void setBankacount_id(int bankacount_id) {
			this.bankacount_id = bankacount_id;
		}

		public String getAccount_type() {
			return account_type;
		}

		public void setAccount_type(String account_type) {
			this.account_type = account_type;
		}

		public int getBankuser_id() {
			return bankuser_id;
		}

		public void setBankuser_id(int bankuser_id) {
			this.bankuser_id = bankuser_id;
		}

		public Float getBalance() {
			return balance;
		}

		public void setBalance(Float balance) {
			this.balance = balance;
		}

		public String getAccount_open() {
			return account_open;
		}

		public void setAccount_open(String account_open) {
			this.account_open = account_open;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((account_open == null) ? 0 : account_open.hashCode());
			result = prime * result + ((account_type == null) ? 0 : account_type.hashCode());
			result = prime * result + ((balance == null) ? 0 : balance.hashCode());
			result = prime * result + bankacount_id;
			result = prime * result + bankuser_id;
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
			BankAccounts other = (BankAccounts) obj;
			if (account_open == null) {
				if (other.account_open != null)
					return false;
			} else if (!account_open.equals(other.account_open))
				return false;
			if (account_type == null) {
				if (other.account_type != null)
					return false;
			} else if (!account_type.equals(other.account_type))
				return false;
			if (balance == null) {
				if (other.balance != null)
					return false;
			} else if (!balance.equals(other.balance))
				return false;
			if (bankacount_id != other.bankacount_id)
				return false;
			if (bankuser_id != other.bankuser_id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "BankAccounts [bankacount_id=" + bankacount_id + ", account_type=" + account_type + ", bankuser_id="
					+ bankuser_id + ", balance=" + balance + ", account_open=" + account_open + "]";
		}
	
		
		
}