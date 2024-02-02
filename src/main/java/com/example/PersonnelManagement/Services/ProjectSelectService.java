package com.example.PersonnelManagement.Services;

import java.util.List;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;

public interface ProjectSelectService {
	
	List<Employee> selectMembers(int hours_worked_pw, String performance, String department)throws NoDetailsFoundException;

}
