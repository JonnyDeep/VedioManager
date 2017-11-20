package com.vedio.dao;

import java.math.BigDecimal;

public class UserDAO {
	private int UserId;
	private String userName;
	private String name;
	private String password;
	private char authority;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getAuthority() {
		return authority;
	}
	public void setAuthority(char authority) {
		this.authority = authority;
	}
	
}
