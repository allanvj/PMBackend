package com.example.PersonnelManagement.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PersonnelManagement.Entities.*;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	

}
