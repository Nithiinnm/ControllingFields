package com.controlling.dto;

//@JsonFilter("employeeFilter")
public class EmployeeDto {
	
	// Dto checking...
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private String nationality;
	private String state;
	private String city;
	private Integer ssn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", nationality=" + nationality + ", state=" + state + ", city=" + city + ", ssn=" + ssn + "]";
	}
	
}
