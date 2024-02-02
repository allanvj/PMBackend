package com.example.PersonnelManagement.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PersonnelManagement.Entities.HR;

@Repository
public interface HRRepo extends JpaRepository<HR, Integer>{


	

}
