package com.controlling.restcontroller;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controlling.dto.EmployeeDto;
import com.controlling.entites.EmployeeEntity;
import com.controlling.response.ResponseHandler;
import com.controlling.service.EmployeeSevice;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeSevice employeeSevice;
	
	@Autowired
	private SimpleFilterProvider filterProvider;
	
//	@GetMapping("/getEmployee/{id}")
//	public Object getEmployee(@PathVariable("id") Integer id){
//		
//		EmployeeEntity employee = employeeSevice.getEmployee(id);
//		EmployeeDto dto = new EmployeeDto();
//		ModelMapper mapper = new ModelMapper();
//		mapper.map(employee, dto);
//		
//		int size = 10;
//		
//		Set<String> fields = new HashSet<>();
//	//	fields.add("id");
//		fields.add("firstName");
//		fields.add("state");
//		fields.add("city");
//		fields.add("ssn");
//		
//		//FilterProvider filterProvider = new SimpleFilterProvider()
//		//		.addFilter("employeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
//		
//
//		MappingJacksonValue mapping = new MappingJacksonValue(dto);
//		mapping.setFilters(filterProvider);
//	//	mapping.setValue(size);
//		ResponseEntity<Object> mappingEntity = new ResponseEntity<Object>((mapping), HttpStatus.OK);
//		
//		return ResponseHandler.generateResponse("SuccessFully Done...", HttpStatus.ACCEPTED, mapping,size);
//		
//		//ResponseEntity<Object> addCustom = addCustom(mappingEntity);
//		
//		//return mappingEntity;
//	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<MappingJacksonValue> getEmployee(@PathVariable("id") Integer id){
		
		EmployeeEntity employee = employeeSevice.getEmployee(id);
		
		int size = 10;
		
		Set<String> fields = new HashSet<>();
		fields.add("data.firstName");
//		fields.add("data.state");
//		fields.add("data.city");
//		fields.add("data.ssn");
		fields.add("size");
		fields.add("data");
		Set<String> fields1= new HashSet<>();
		fields.add("firstName");
//		fields.add("data.state");
//		fields.add("data.city");
//		fields.add("data.ssn");
		FilterProvider filterProvider1 = new SimpleFilterProvider()
				.addFilter("employeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields1));
		MappingJacksonValue mapping1 = new MappingJacksonValue(employee);
		mapping1.setFilters(filterProvider1);
		ResponseHandler respHandler = new ResponseHandler();
		
		
		respHandler.setData(mapping1);
		respHandler.setMessage("SuccessFully");
		respHandler.setSize(10);
		respHandler.setStatus(200);
		
		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("employeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
		

		MappingJacksonValue mapping = new MappingJacksonValue(respHandler);
		mapping.setFilters(filterProvider);
		
		
		return new ResponseEntity<MappingJacksonValue>(mapping, HttpStatus.OK);
	}
	
	
	public ResponseEntity<Object> addCustom(Object mappingEntity){
		
		System.out.println("Mapping Entity :"+mappingEntity);
		
		int size =10;
		
		//ResponseEntity<Object> resEntity = new ResponseEntity<Object>(mappingEntity, HttpStatus.OK);
		return ResponseHandler.generateResponse("SuccessFully Done...", HttpStatus.ACCEPTED, mappingEntity, size);
	//	return resEntity;
		
//		FilterProvider filterProvider = new SimpleFilterProvider()
//				.addFilter("employeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
//
//		MappingJacksonValue mapping = new MappingJacksonValue(employee);
//		mapping.setFilters(filterProvider);
//	//	mapping.setValue(size);
//		ResponseEntity<Object> mappingEntity = new ResponseEntity<Object>(mapping, HttpStatus.OK);
//		
//		return ResponseHandler.generateResponse("SuccessFully Done...", HttpStatus.ACCEPTED, mapping,size);
		
	//	return mappingEntity;
	}
	
	
	
	
	@GetMapping("/getEmpByParam/{id}")
	public ResponseEntity<MappingJacksonValue> getEmployeeByParam(@PathVariable("id") Integer id,
																  @RequestParam Set<String> fields){
		
		EmployeeEntity employee = employeeSevice.getEmployee(id);
		
//		Set<String> fields = new HashSet<>();
//		fields.add("id");
//		fields.add("firstName");
//		fields.add("state");
//		fields.add("city");
//		fields.add("ssn");
		
		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("employeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

		MappingJacksonValue mapping = new MappingJacksonValue(employee);
		mapping.setFilters(filterProvider);
		ResponseEntity<MappingJacksonValue> mappingEntity = new ResponseEntity<MappingJacksonValue>(mapping, HttpStatus.OK);
		
		return mappingEntity;
	}
	
	@GetMapping("/getEmployeeall/{id}")
	public ResponseEntity<Object> getEmployeeAll(@PathVariable("id") Integer id){
		
		EmployeeEntity employee = employeeSevice.getEmployee(id);
		
		int size = 10;
		
		return ResponseHandler.generateResponse("SuccessFully Done...", HttpStatus.ACCEPTED, employee,size);
		
		//return employee;
	}
	
	@PostMapping(value = "/saveEmployee")
	public String saveUser(@RequestBody EmployeeEntity employee) {
		
		boolean saveemployee = employeeSevice.saveEmployee(employee);
		
		if(saveemployee == true) {
			
			return "Success";
		}
		return "Failed";
	}
	
}
