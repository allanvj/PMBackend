package com.example.PersonnelManagement.Functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;
import com.example.PersonnelManagement.Repos.EmployeeRepo;
import com.example.PersonnelManagement.Repos.HRRepo;
import com.example.PersonnelManagement.Repos.ReportRepo;
import com.example.PersonnelManagement.Services.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService{
	
	@Autowired
	public EmployeeRepo employeerepo;
	
	@Autowired
	public HRRepo hrrepo;
	
	@Autowired
	public ReportRepo reportrepo;

	@Override
	public Employee inspectDetail(int employee_id) throws InvalidIdException{
		if(employeerepo.existsById(employee_id)) {
			return employeerepo.findById(employee_id).get();
		}else {
			throw new InvalidIdException("ID is not valid");
		}
	}

	@Override
	public HR viewHR(int hr_id) throws InvalidIdException{
		if(hrrepo.existsById(hr_id)) {
			return hrrepo.findById(hr_id).get();
		}else {
			throw new InvalidIdException("ID is not valid");
		}
	}

	@Override
	public void reportUpdate(Report report) throws InvalidFormatException{
		if(report.getEmployee_id()!=0||report.getEmp_name()!=null||report.getChanges()!=null||report.getUpdated_info()!=null) {
			reportrepo.save(report);
		}else {
			throw new InvalidFormatException("Given Format is Invalid");
		}
		
	}

}
