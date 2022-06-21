package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product10")
public class Product 
{
	@Id
	private int prdtid;
	private float prdtprice;
	private String prdtname;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrdtid() {
		return prdtid;
	}
	public void setPrdtid(int prdtid) {
		this.prdtid = prdtid;
	}
	public String getPrdtname() {
		return prdtname;
	}
	public void setPrdtname(String prdtname) {
		this.prdtname = prdtname;
	}
	public float getPrdtprice() {
		return prdtprice;
	}
	public void setPrdtprice(float prdtprice) {
		this.prdtprice = prdtprice;
	}	
	public Product(int prdtid, float prdtprice, String prdtname, String description) {
		super();
		this.prdtid = prdtid;
		this.prdtprice = prdtprice;
		this.prdtname = prdtname;
		this.description = description;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [prdtid=" + prdtid + ", prdtprice=" + prdtprice + ", prdtname=" + prdtname + ", description="
				+ description + "]";
	}
}
