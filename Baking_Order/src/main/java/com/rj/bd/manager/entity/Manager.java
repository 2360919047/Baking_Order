package com.rj.bd.manager.entity;

public class Manager {
	
	public int id;
	public String username;
	public String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
