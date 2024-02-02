package com.example.PersonnelManagement.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;

public interface AdminService {
	
	void enterDetail(HR hr) throws InvalidFormatException;
	
	void addEmp(Employee employee)throws InvalidFormatException;
	
	Employee updateEmp(int employee_id, Employee emp)throws InvalidIdException;
	
	void deleteEmp(int employee_id)throws InvalidIdException;
	
	Employee findEmployee(int employee_id)throws InvalidIdException;
	
	List<Report> viewReport()throws NoDetailsFoundException;
	
	List<Employee> getEmployee()throws NoDetailsFoundException;
	
	List<Employee> findByPerformance(String performance)throws NoDetailsFoundException;
	
	List<Employee> findByDepartment(String department)throws NoDetailsFoundException;

	List<HR> getHR()throws NoDetailsFoundException;
	
}
