package com.example.PersonnelManagement.Repos;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



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
import com.example.PersonnelManagement.Functions.EmployeeServiceImplement;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class HRRepoTest {
	
	@Mock
	private EmployeeRepo employeerepo;
	
	@Mock
	private ReportRepo reportrepo;
	
	@Mock
	private HRRepo hrrepo;
	
	
	@InjectMocks
	private EmployeeServiceImplement employeeService;
	
	 @Test
	    public void testInspectDetail() throws InvalidIdException {
	        int validId = 1;
	        Employee expectedEmployee = new Employee(validId,"Sakst",345643234,36,"Manali","sakthi@gmail.com",200,"ok","cse");

	        
	        when(employeerepo.existsById(validId)).thenReturn(true);
	        when(employeerepo.findById(validId)).thenReturn(Optional.of(expectedEmployee));

	        Employee actualEmployee = employeeService.inspectDetail(validId);

	        assertNotNull(actualEmployee);
	        assertEquals(expectedEmployee, actualEmployee);

	        verify(employeerepo).existsById(validId);
	        verify(employeerepo).findById(validId);
	    }
	 
	 @Test
	    public void testViewHR() throws InvalidIdException {
	        int validId = 1;
	        HR expectedHR = new HR(validId, "Jo",309786543,"jo@gmail.com","joeljoel");
	        when(hrrepo.existsById(validId)).thenReturn(true);
	        when(hrrepo.findById(validId)).thenReturn(Optional.of(expectedHR));
	        HR actualHR = employeeService.viewHR(validId);
	        assertNotNull(actualHR);
	        assertEquals(expectedHR, actualHR);
	        verify(hrrepo).existsById(validId);
	        verify(hrrepo).findById(validId);
	    }
	 
	 @Test
	 public void testReportUpdate() throws InvalidFormatException {
		 Report report=new Report(1,101,"Stark","Stark@gmail.com","sakshi");
		 employeeService.reportUpdate(report);
		 verify(reportrepo, times(1)).save(report);
	}
	 
}
