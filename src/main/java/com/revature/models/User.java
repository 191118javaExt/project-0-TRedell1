package com.revature.models;

public class User {
	private int id;
	private String bank_type_id; 
	private String first_name;
	private String last_name;
	private String email;
	private int password;
	//private int hashedpassword;
	// ask how to use hash password
	
	public User() {
		super();
	}
	
	public User(int id, String bank_type_id, String first_name, String last, String username, int pw) {
		super();
		
		this.id = id;
		this.bank_type_id = bank_type_id;
		this.first_name = first_name;
		this.last_name = last;
		this.email = username;
		this.password =pw;
		//this.hashedpassword = hashedpassword;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBank_type_id() {
		return bank_type_id;
	}

	public void setBank_type_id(String bank_type_id) {
		this.bank_type_id = bank_type_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank_type_id == null) ? 0 : bank_type_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + password;
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
		User other = (User) obj;
		if (bank_type_id == null) {
			if (other.bank_type_id != null)
				return false;
		} else if (!bank_type_id.equals(other.bank_type_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password != other.password)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", bank_type_id=" + bank_type_id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", password=" + password + "]";
	}
	
	
		
}
