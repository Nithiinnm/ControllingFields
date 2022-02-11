package com.controlling.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("employeeFilter")
public class ResponseHandler {
	
	
	
	private String message;
	private int status;
	private Object data;
	private int size;
	
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, 
															Object responseObject,int size){
		
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObject);
        map.put("size", size);

        return new ResponseEntity<Object>(map,status);
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ResponseHandler [message=" + message + ", status=" + status + ", data=" + data + ", size=" + size + "]";
	}

	
}
