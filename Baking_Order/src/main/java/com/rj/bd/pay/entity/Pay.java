package com.rj.bd.pay.entity;

public class Pay {
	private String pay_id;   //id
	private String pay_name;  //支付方式名称
	private String remarks;   //描述
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getPay_name() {
		return pay_name;
	}
	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "Pay [pay_id=" + pay_id + ", pay_name=" + pay_name + ", remarks=" + remarks + "]";
	}
	
	
}
