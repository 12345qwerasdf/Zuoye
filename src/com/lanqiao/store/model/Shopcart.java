package com.lanqiao.store.model;

public class Shopcart {
	private int id;
	private String cname;
	private String price;
	private int num = 1;
	private String gif;
	
	private String state;
	private int cid;
	private int userid;
	private double count;
	
	
	public double getCount() {
		return count;
	}
	public void setCount(double count2) {
		this.count = count2;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGif() {
		return gif;
	}
	public void setGif(String gif) {
		this.gif = gif;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "shopcart [id=" + id + ",  price=" +price + ",cname=" + cname +" ,"
				+ "gif=" + gif +",num=" + num +",cid=" + cid +",userid=" + userid +",count=" + count +"]";
	}
	
}
