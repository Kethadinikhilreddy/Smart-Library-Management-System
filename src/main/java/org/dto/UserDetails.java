package org.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="password",nullable = false)
	private String password;
	@Column(name="mobilenumber",nullable = false)
	private long mobilenumber;
	
	public UserDetails() {
		super();
	}

	public UserDetails(String name, String email, String password, long mobilenumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobilenumber = mobilenumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobilenumber=" + mobilenumber + "]";
	}
	
	
	
	

}
