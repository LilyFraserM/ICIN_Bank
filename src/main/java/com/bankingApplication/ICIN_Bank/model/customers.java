package com.bankingApplication.ICIN_Bank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custid")
	int custid;
	
	@Column(name = "fname")
	String fname;
	
	@Column(name = "mname")
	String mname;
	
	@Column(name = "ltname")
	String ltname;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "mobileno")
	int mobileno;
	
	@Column(name = "occupation")
	String occupation;
	
	@Column(name = "dob")
	Date dob;
	
	
	public customers() {
		
	}
	public customers(int custid, String fname, String mname, String ltname, String city, int mobileno,
			String occupation, Date dob) {
		super();
		this.custid = custid;
		this.fname = fname;
		this.mname = mname;
		this.ltname = ltname;
		this.city = city;
		this.mobileno = mobileno;
		this.occupation = occupation;
		this.dob = dob;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLtname() {
		return ltname;
	}
	public void setLtname(String ltname) {
		this.ltname = ltname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "customers [custid=" + custid + ", fname=" + fname + ", mname=" + mname + ", ltname=" + ltname
				+ ", city=" + city + ", mobileno=" + mobileno + ", occupation=" + occupation + ", dob=" + dob + "]";
	}
	
	

}
