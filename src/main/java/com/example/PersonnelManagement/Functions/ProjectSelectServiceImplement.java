package com.example.PersonnelManagement.Functions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;
import com.example.PersonnelManagement.Repos.EmployeeRepo;
import com.example.PersonnelManagement.Services.ProjectSelectService;

@Service
public class ProjectSelectServiceImplement implements ProjectSelectService{
	
	@Autowired
	public EmployeeRepo employeerepo;

	@Override
	public List<Employee> selectMembers(int hours_worked_pw, String performance, String department) throws NoDetailsFoundException{
		if(employeerepo!=null) {
		List<Employee> E= employeerepo.findAll();
		List<Employee> result= new ArrayList<>();
		E.forEach(k->{
			if(k.getDepartment().equalsIgnoreCase(department) && k.getPerformance().equalsIgnoreCase(performance) && k.getHours_worked_pw()==hours_worked_pw) {
				result.add(k);
			}
		});
		return result;
		}else {
			throw new NoDetailsFoundException("List is empty");
		}
	}

}
