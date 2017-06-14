package com.chinasoft.bean;

public class Login {
	private int id;
	private String name;
	private String pwd;
	private String checkcode;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", pwd=" + pwd + ", checkcode=" + checkcode + "]";
	}
	
}
