package com.example.PersonnelManagement.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "report_no")
	int report_no;
	int employee_id;
	String emp_name;
	String changes;
	String updated_info;
	
	public Report(int report_no, int employee_id, String emp_name, String changes, String updated_info) {
		super();
		this.report_no = report_no;
		this.employee_id = employee_id;
		this.emp_name = emp_name;
		this.changes = changes;
		this.updated_info = updated_info;
	}
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
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
	public String getChanges() {
		return changes;
	}
	public void setChanges(String change) {
		this.changes = change;
	}
	public String getUpdated_info() {
		return updated_info;
	}
	public void setUpdated_info(String updated_info) {
		this.updated_info = updated_info;
	}
	
	
	

}
