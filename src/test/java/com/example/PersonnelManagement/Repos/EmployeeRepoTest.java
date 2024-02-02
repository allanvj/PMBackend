package com.example.PersonnelManagement.Repos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.PersonnelManagement.Entities.Employee;
import com.example.PersonnelManagement.Entities.HR;
import com.example.PersonnelManagement.Entities.Report;
import com.example.PersonnelManagement.Exception.InvalidFormatException;
import com.example.PersonnelManagement.Exception.InvalidIdException;
import com.example.PersonnelManagement.Exception.NoDetailsFoundException;
import com.example.PersonnelManagement.Functions.AdminServiceImplement;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeRepoTest {
	
	@Mock
	private EmployeeRepo employeerepo;
	
	@Mock
	private ReportRepo reportrepo;
	
	@Mock
	private HRRepo hrrepo;
	
	
	@InjectMocks
	private AdminServiceImplement adminService;
	
	@Test
	public void testAddEmp() throws InvalidFormatException{
		Employee emp=new Employee(101,"Sakst",345643234,36,"Manali","sakthi@gmail.com",200,"ok","cse");
		adminService.addEmp(emp);
		verify(employeerepo, times(1)).save(emp);
	}
	
	@Test
	public void testGetEmployee() throws NoDetailsFoundException{
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(103,"Shusti",345254234,26,"Manali","shus@gmail.com",24550,"ok","cse"));
		emp.add(new Employee(104,"Anand",343557234,36,"Anna Nagar","Anand@gmail.com",25500,"good","it"));
        when(employeerepo.findAll()).thenReturn(emp);
		
		List<Employee> result = adminService.getEmployee();
		assertEquals(2,result.size());
		assertEquals("Shusti", result.get(0).getEmp_name());
		assertEquals("Anand", result.get(1).getEmp_name());
	}
	
	@Test
	public void testDeleteEmp() throws InvalidIdException{
	        int employeeId = 105;
	        when(employeerepo.existsById(employeeId)).thenReturn(true);
	        adminService.deleteEmp(employeeId);
	        verify(employeerepo, times(1)).deleteById(employeeId);
	    }
	
	@Test
	public void enterDetail() throws InvalidFormatException{
		HR hr=new HR(1002,"Stark",736482465,"Stark@gmail.com","sakshi");
		adminService.enterDetail(hr);
		verify(hrrepo, times(1)).save(hr);
	}
	
	@Test
	public void testviewReport() throws NoDetailsFoundException{
		List<Report> report = new ArrayList<>();
		report.add(new Report(1,103,"Shusti","Address","Adyar"));
		report.add(new Report(2,104,"Anand","Email","Ana@gmail.com"));
        when(reportrepo.findAll()).thenReturn(report);
		
		List<Report> result = adminService.viewReport();
		assertEquals(2,result.size());
		assertEquals(103, result.get(0).getEmployee_id());
		assertEquals(104, result.get(1).getEmployee_id());
	}
	
	 @Test
	    public void testfindEmployee() throws InvalidIdException {
	        int employeeId = 123;
	        Employee employee = new Employee(123,"Shusti",345254234,26,"Manali","shus@gmail.com",24550,"ok","cse");
	        when(employeerepo.existsById(employeeId)).thenReturn(true);
	        when(employeerepo.findById(employeeId)).thenReturn(Optional.of(employee));
	        Employee result = adminService.findEmployee(employeeId);
	        assertEquals(employee, result);
	    }
	 
	 @Test
	    public void testFindByPerformance() throws NoDetailsFoundException {
	        String performance = "ok";
	        List<Employee> employeeList = new ArrayList<>();
	        employeeList.add(new Employee(103,"Shusti",345484234,26,"Manali","shus@gmail.com",24550,"ok","cse"));
	        employeeList.add(new Employee(104,"Sahil",785335634,36,"Bali","sahil@gmail.com",25550,"good","it"));
	        employeeList.add(new Employee(105,"Anchana",344336774,45,"Anna Nagar","anchu@gmail.com",20000,"ok","cse"));

	        when(employeerepo.findAll()).thenReturn(employeeList);

	        List<Employee> result = adminService.findByPerformance(performance);

	        assertEquals(2, result.size());
	        assertEquals("Shusti", result.get(0).getEmp_name());
	        assertEquals("Anchana", result.get(1).getEmp_name());
	    }
	 
	 @Test
	    public void testFindByDepartment() throws NoDetailsFoundException {
	        String department = "it";
	        List<Employee> employeeList = new ArrayList<>();
	        employeeList.add(new Employee(103,"Shusti",345484234,26,"Manali","shus@gmail.com",24550,"ok","cse"));
	        employeeList.add(new Employee(104,"Sahil",785335634,36,"Bali","sahil@gmail.com",25550,"good","it"));
	        employeeList.add(new Employee(105,"Anchana",344336774,45,"Anna Nagar","anchu@gmail.com",20000,"ok","it"));

	        when(employeerepo.findAll()).thenReturn(employeeList);

	        List<Employee> result = adminService.findByDepartment(department);

	        assertEquals(2, result.size());
	        assertEquals("Sahil", result.get(0).getEmp_name());
	        assertEquals("Anchana", result.get(1).getEmp_name());
	    }

	

}
