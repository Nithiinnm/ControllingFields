package com.controlling.service;

import com.controlling.entites.EmployeeEntity;

public interface EmployeeSevice {

	public boolean saveEmployee(EmployeeEntity employee);
	
	public EmployeeEntity getEmployee(int id);
	
	
	
	
}
