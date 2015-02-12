package com.wangxue.bean;

public class User {

	 private String name;
	 private String cateurl;
	 private String catetitle;
	 private String catecontent;
	 private String cateprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCateurl() {
		return cateurl;
	}
	public void setCateurl(String cateurl) {
		this.cateurl = cateurl;
	}
	public String getCatetitle() {
		return catetitle;
	}
	public void setCatetitle(String catetitle) {
		this.catetitle = catetitle;
	}
	public String getCatecontent() {
		return catecontent;
	}
	public void setCatecontent(String catecontent) {
		this.catecontent = catecontent;
	}
	public String getCateprice() {
		return cateprice;
	}
	public void setCateprice(String cateprice) {
		this.cateprice = cateprice;
	}
	public User(String name, String cateurl, String catetitle,
			String catecontent, String cateprice) {
		super();
		this.name = name;
		this.cateurl = cateurl;
		this.catetitle = catetitle;
		this.catecontent = catecontent;
		this.cateprice = cateprice;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", cateurl=" + cateurl + ", catetitle="
				+ catetitle + ", catecontent=" + catecontent + ", cateprice="
				+ cateprice + "]";
	}
	 
	 
}
