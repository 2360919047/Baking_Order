package com.rj.bd.Distribution.entity;

public class Kuaidi {
	
	public String e_id;
	public String e_name;
	public String e_describe;
	
	
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_describe() {
		return e_describe;
	}
	public void setE_describe(String e_describe) {
		this.e_describe = e_describe;
	}
	
	@Override
	public String toString() {
		return "Kuaidi [e_id=" + e_id + ", e_name=" + e_name + ", e_describe=" + e_describe + "]";
	}
	
	
	
}
