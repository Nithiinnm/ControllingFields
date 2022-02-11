package com.controlling.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlling.entites.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Serializable> {
	
	

}
