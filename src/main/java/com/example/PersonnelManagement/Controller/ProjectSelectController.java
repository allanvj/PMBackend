package com.example.PersonnelManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;
import com.example.PersonnelManagement.Services.ProjectSelectService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ProjectSelect")
public class ProjectSelectController {
	
	@Autowired
	public ProjectSelectService project;
	
	@GetMapping("/Filter/{hours_worked_pw}/{performance}/{department}")
	public List<Employee> selectMembers(@PathVariable("hours_worked_pw") int hrs, @PathVariable("performance") String performance, @PathVariable("department") String department) throws NoDetailsFoundException{
		return project.selectMembers(hrs, performance, department);
	}
	

}
