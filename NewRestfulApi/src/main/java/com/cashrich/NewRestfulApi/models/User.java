package com.cashrich.NewRestfulApi.models;


import jakarta.persistence.*;


@Entity
@Table (name ="users")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column (nullable = false ,length = 45,unique = true)
	private String email;
	
	@Column (nullable = false ,length = 15,unique =true)
	private String username;
	
	@Column(nullable = false,length = 60)
	private String password;
	
	@Column(nullable = false ,length = 20)
	private String first_name;
	
	@Column(nullable = false,length = 20)
	private String last_name;
	
	@Column(nullable = false,length = 11)
	private String mobile_number;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
