package com.controlling;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	  @Bean	
	  public SimpleFilterProvider filterProvider() {
	        Set<String> fields = new HashSet<>();
	    		fields.add("firstName");
	    		fields.add("state");
	    		fields.add("city");
	    		fields.add("ssn");
	        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().addFilter("employeeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
	        return simpleFilterProvider;
	    }

}
