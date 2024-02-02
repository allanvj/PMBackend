package com.example.PersonnelManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	int employee_id;
	String emp_name;
	long phone_no;
	int hours_worked_pw;
	String address;
	String email;
	int salary;
	String performance;
	String department;
	

	
	public Employee(int employee_id, String emp_name, long phone_no, int hours_worked_pw, String address, String email,
			int salary, String performance, String department) {
		super();
		this.employee_id = employee_id;
		this.emp_name = emp_name;
		this.phone_no = phone_no;
		this.hours_worked_pw = hours_worked_pw;
		this.address = address;
		this.email = email;
		this.salary = salary;
		this.performance = performance;
		this.department = department;
	}
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public int getHours_worked_pw() {
		return hours_worked_pw;
	}
	public void setHours_worked_pw(int hours_worked_pw) {
		this.hours_worked_pw = hours_worked_pw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
