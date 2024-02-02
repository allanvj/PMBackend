package com.example.PersonnelManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;
import com.example.PersonnelManagement.Services.AdminService;


@CrossOrigin("*")
@RestController
@RequestMapping("/HRPage")
public class AdminController {
	
	@Autowired
	public AdminService admin;
	
	@PostMapping("/HRInfo")
	public void enterDetail(@RequestBody HR hr) throws InvalidFormatException{
		admin.enterDetail(hr);
	}
	
	@PostMapping("/AddEmp")
	public void addEmp(@RequestBody Employee emp) throws InvalidFormatException{
		admin.addEmp(emp);
	}
	
	@GetMapping("/Emp/{employee_id}")
	public Employee findEmployee(@PathVariable("employee_id") int empid) throws InvalidIdException{
		return admin.findEmployee(empid);
	}
	
	@DeleteMapping("/deleteEmp/{employee_id}")
	public void deleteEmp(@PathVariable("employee_id") int empid) throws InvalidIdException{
		admin.deleteEmp(empid);
	}
	
	@GetMapping("/AllEmployee")
	public List<Employee> getEmployee() throws NoDetailsFoundException{
		return admin.getEmployee();
	}
	
	@PutMapping("/UpdateEmp/{employee_id}")
	public Employee updateEmp(@PathVariable int employee_id,@RequestBody Employee emp) throws InvalidIdException{
		return admin.updateEmp(employee_id,emp);
	}
	
	@GetMapping("/performance/{performance}")
	public List<Employee> findEmployeeByPerformance(@PathVariable("performance") String performance)throws NoDetailsFoundException{
		return admin.findByPerformance(performance);
	}
	
	@GetMapping("/department/{department}")
	public List<Employee> findEmployeeByDepartment(@PathVariable("department") String department)throws NoDetailsFoundException{
		return admin.findByDepartment(department);
	}
	
	@GetMapping("/report")
	public List<Report> viewReport()throws NoDetailsFoundException{
		return admin.viewReport();
	}
	
	@GetMapping("/AllHr")
	public List<HR> getHR() throws NoDetailsFoundException{
		return admin.getHR();
	}
	
	

}
