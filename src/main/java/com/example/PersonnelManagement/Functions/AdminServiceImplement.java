package com.example.PersonnelManagement.Functions;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;
import com.example.PersonnelManagement.Repos.EmployeeRepo;
import com.example.PersonnelManagement.Repos.HRRepo;
import com.example.PersonnelManagement.Repos.ReportRepo;
import com.example.PersonnelManagement.Services.AdminService;

@Service
public class AdminServiceImplement implements AdminService {
	
	@Autowired
	public EmployeeRepo employeerepo;
	
	@Autowired
	public HRRepo hrrepo;
	
	@Autowired
	public ReportRepo reportrepo;
	
	private static final Logger log = LoggerFactory.getLogger(AdminServiceImplement.class);
	
	public void addEmp(Employee employee) throws InvalidFormatException{
		if(employee.getEmployee_id()!=0||employee.getEmp_name()!=null||employee.getAddress()!=null||employee.getEmail()!=null||employee.getDepartment()!=null||employee.getHours_worked_pw()!=0||employee.getPerformance()!=null||employee.getPhone_no()!=0||employee.getSalary()!=0) {
			if (employeerepo.existsById(employee.getEmployee_id())) {
					throw new InvalidFormatException("Given Format is Invalid");
		    } else {
		        employeerepo.save(employee);
		        log.info("Employee detail is saved");
			}
		}else {
			throw new InvalidFormatException("Given Format is Invalid");
		}
	}
	
	public void deleteEmp(int employee_id) throws InvalidIdException{
		if(employeerepo.existsById(employee_id)) {
			employeerepo.deleteById(employee_id);
		}else {
			throw new InvalidIdException("ID is not valid");
		}
	}

	public Employee updateEmp(int employee_id, Employee emp) throws InvalidIdException{
		if(employeerepo.existsById(employee_id)) {
		Employee oldEmp = employeerepo.findById(employee_id).orElse(null);
		oldEmp.setEmployee_id(emp.getEmployee_id());
		oldEmp.setEmp_name(emp.getEmp_name());
		oldEmp.setPhone_no(emp.getPhone_no());
		oldEmp.setSalary(emp.getSalary());
		oldEmp.setHours_worked_pw(emp.getHours_worked_pw());
		oldEmp.setAddress(emp.getAddress());
		oldEmp.setEmail(emp.getEmail());
		oldEmp.setDepartment(emp.getDepartment());
		oldEmp.setPerformance(emp.getPerformance());
		employeerepo.save(oldEmp);
		log.info("Employee Info is updated");
		return oldEmp;
	}else {
		throw new InvalidIdException("ID is not valid");
	}
		
	}

	public List<Employee> getEmployee() throws NoDetailsFoundException{
		if(employeerepo!=null) {
			log.info("Get List of all Employees");
			return employeerepo.findAll();
	}else {
		throw new NoDetailsFoundException("List is empty");
	}
	}

	public List<Employee> findByPerformance(String performance) throws NoDetailsFoundException{
		if(employeerepo!=null) {
		List<Employee> E= employeerepo.findAll();
		List<Employee> result= new ArrayList<>();
		E.forEach(k->{
			if(k.getPerformance().equalsIgnoreCase(performance)){
				result.add(k);
			}
		});
		return result;
		}else {
			throw new NoDetailsFoundException("List is empty");
		}
	}

	public List<Employee> findByDepartment(String department) throws NoDetailsFoundException{
		if(employeerepo!=null) {
		List<Employee> E= employeerepo.findAll();
		List<Employee> result= new ArrayList<>();
		E.forEach(k->{
			if(k.getDepartment().equalsIgnoreCase(department)) {
				result.add(k);
			}
		});
		return result;
		}else {
			throw new NoDetailsFoundException("List is empty");
		}
	}

	public Employee findEmployee(int employee_id) throws InvalidIdException{
		if(employeerepo.existsById(employee_id)) {
			return employeerepo.findById(employee_id).get();
		}else {
			throw new InvalidIdException("ID is not valid");
		}
	}

	public void enterDetail(HR hr) throws InvalidFormatException{
		if(hr.getHr_name()!=null||hr.getHr_id()!=0||hr.getHr_phno()!=0||hr.getHr_email()!=null||hr.getPassword()!=null) {
			if (hrrepo.existsById(hr.getHr_id())) {
				throw new InvalidFormatException("Given Format is Invalid");
			}else {
				hrrepo.save(hr);
			}
		}else {
			throw new InvalidFormatException("Given Format is Invalid");
		}
	}

	public List<Report> viewReport() throws NoDetailsFoundException{
		if(reportrepo!=null) {
			return reportrepo.findAll();
		}else {
			throw new NoDetailsFoundException("List is empty");
		}
	}

	@Override
	public List<HR> getHR() throws NoDetailsFoundException {
		if(hrrepo!=null) {
			return hrrepo.findAll();
	}else {
		throw new NoDetailsFoundException("List is empty");
	}
	}
	
	

}
