package com.example.PersonnelManagement.Services;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;

public interface EmployeeService {
	
	Employee inspectDetail(int employee_id)throws InvalidIdException;
	
	HR viewHR(int hr_id)throws InvalidIdException;
	
	void reportUpdate(Report report)throws InvalidFormatException;

}
