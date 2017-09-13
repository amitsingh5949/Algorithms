package com.javaDwarf.dataStructure.doubleEndedLinkedList;

public class Employee {
	
	private int empId;
	private String name;
	private String role;
	
	public Employee(int empId, String name, String role) {
		super();
		this.empId = empId;
		this.name = name;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee ID : " + this.getEmpId() + " - Name : " + this.getName() + " - Role : " + this.getRole();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
