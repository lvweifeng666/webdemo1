package com.bean;
public class cadmin {
	//注册时候的字段
	private String cid;
	private String sname;
	private String passwd;
	private String sex;
	private String address;
	private String birthday;
	private String zdate;
	public cadmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cadmin(String cid, String sname, String passwd, String sex, String address, String birthday, String zdate) {
		super();
		this.cid = cid;
		this.sname = sname;
		this.passwd = passwd;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
		this.zdate = zdate;
	}
	public cadmin(String sname, String passwd, String sex, String address, String string, String string2) {
		super();
		this.sname = sname;
		this.passwd = passwd;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
		this.zdate = zdate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getZdate() {
		return zdate;
	}
	public void setZdate(String zdate) {
		this.zdate = zdate;
	}

	
	
	
	
	
	
	

	/*
	 * public cadmin() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //添加专用 public cadmin(String sname, String passwd, String sex, String address,
	 * String birthday, String zdate) { super(); this.sname = sname; this.passwd =
	 * passwd; this.sex = sex; this.address = address; this.birthday = birthday;
	 * this.zdate = zdate; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public cadmin(String cid, String sname, String passwd, String sex, String
	 * address, String birthday, String zdate) { super(); this.cid = cid; this.sname
	 * = sname; this.passwd = passwd; this.sex = sex; this.address = address;
	 * this.birthday = birthday; this.zdate = zdate; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public String getCid() { return cid; } public void setCid(String cid) {
	 * this.cid = cid; } public String getSname() { return sname; } public void
	 * setSname(String sname) { this.sname = sname; } public String getPasswd() {
	 * return passwd; } public void setPasswd(String passwd) { this.passwd = passwd;
	 * } public String getSex() { return sex; } public void setSex(String sex) {
	 * this.sex = sex; } public String getAddress() { return address; } public void
	 * setAddress(String address) { this.address = address; } public String
	 * getBirthday() { return birthday; } public void setBirthday(String birthday) {
	 * this.birthday = birthday; } public String getZdate() { return zdate; } public
	 * void setZdate(String zdate) { this.zdate = zdate; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Override public String toString() { return "cadmin [cid=" + cid + ", sname="
	 * + sname + ", passwd=" + passwd + ", sex=" + sex + ", address=" + address +
	 * ", birthday=" + birthday + ", zdate=" + zdate + "]"; }
	 */
	
	
}
