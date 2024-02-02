package com.example.PersonnelManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;
import com.example.PersonnelManagement.Services.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeService empService;
	
	@GetMapping("/ViewDetail/{employee_id}")
	public Employee inspectDetail(@PathVariable("employee_id") int employee_id) throws InvalidIdException{
		return empService.inspectDetail(employee_id);
	}
	
	@GetMapping("/HRDetail/{hr_id}")
	public HR viewHR(@PathVariable("hr_id") int hrid) throws InvalidIdException{
		return empService.viewHR(hrid);
	}
	
	@PostMapping("/ReportUpdate")
	public void reportUpdate(@RequestBody Report report) throws InvalidFormatException{
		empService.reportUpdate(report);
	}

}
