package com.lanqiao.store.model;

public class Order {
	private String ordernum;
	private int u_id;
	private String totalmoney;
	private String address;
	private int status;
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(String totalmoney) {
		this.totalmoney = totalmoney;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String ordernum, int u_id, String totalmoney, String address, int status) {
		super();
		this.ordernum = ordernum;
		this.u_id = u_id;
		this.totalmoney = totalmoney;
		this.address = address;
		this.status = status;
	}
	
	

}
