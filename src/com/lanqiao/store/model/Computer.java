package com.lanqiao.store.model;

import java.io.Serializable;

public class Computer implements Serializable {
	private int cid;
	//private String siz;
	private String color;
	private String cpu;
	private String gra;
	private String gif;
	private String price;
	private int inventory;
	private int sell;
	private String mold;
	private int brand;
	private String cname;
	private int discount;
	private Integer count=1;
	public Integer getCount() {
		return count;
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public Computer() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getGra() {
		return gra;
	}
	public void setGra(String gra) {
		this.gra = gra;
	}
	public String getGif() {
		return gif;
	}
	public void setGif(String gif) {
		this.gif = gif;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public String getMold() {
		return mold;
	}
	public void setMold(String mold) {
		this.mold = mold;
	}
	public int getBrand() {
		return brand;
	}
	public void setBrand(int string) {
		this.brand = string;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "computer [id=" + cid + ",  brand=" + brand + ","
				+ "cname=" + cname +" ,gif=" + gif +",discount=" + discount +"]";
	}
	
	
}
