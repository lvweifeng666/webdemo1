package com.bean;

public class record {
	//×¢²áÊ±ºòµÄ×Ö¶Î
	private String cname ;
	private String IDnumber;
	private String age;
	private String sex;
	private String introduce;
	private String fname;
	public record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public record(String cname, String iDnumber, String age, String sex, String introduce, String fname) {
		super();
		this.cname = cname;
		IDnumber = iDnumber;
		this.age = age;
		this.sex = sex;
		this.introduce = introduce;
		this.fname = fname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "record [cname=" + cname + ", IDnumber=" + IDnumber + ", age=" + age + ", sex=" + sex + ", introduce="
				+ introduce + ", fname=" + fname + "]";
	}
	

	
	
}

