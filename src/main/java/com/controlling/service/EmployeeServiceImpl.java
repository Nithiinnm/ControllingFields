
package com.controlling.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlling.entites.EmployeeEntity;
import com.controlling.repositories.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeSevice{

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public boolean saveEmployee(EmployeeEntity employee) {
		
		EmployeeEntity saveEmployee = employeeRepo.save(employee);
		
		if(saveEmployee.getId() != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public EmployeeEntity getEmployee(int id) {

		Optional<EmployeeEntity> findById = employeeRepo.findById(id);
		
		EmployeeEntity empObj = findById.get();
		
		return empObj;
	}


	
}
