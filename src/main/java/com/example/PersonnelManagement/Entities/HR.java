package com.example.PersonnelManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HR {
	
	@Id
	int hr_id;
	String hr_name;
	long hr_phno;
	String hr_email;
	String password;
	
	public HR(int hr_id, String hr_name, long hr_phno, String hr_email, String password) {
		super();
		this.hr_id = hr_id;
		this.hr_name = hr_name;
		this.hr_phno = hr_phno;
		this.hr_email = hr_email;
		this.password=password;	
		}
	
	public HR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHr_id() {
		return hr_id;
	}
	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}
	public String getHr_name() {
		return hr_name;
	}
	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}
	public long getHr_phno() {
		return hr_phno;
	}
	public void setHr_phno(long hr_phno) {
		this.hr_phno = hr_phno;
	}
	public String getHr_email() {
		return hr_email;
	}
	public void setHr_email(String hr_email) {
		this.hr_email = hr_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
