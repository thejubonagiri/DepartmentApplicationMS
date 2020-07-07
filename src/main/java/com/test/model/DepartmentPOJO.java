package com.test.model;

import java.util.List;

public class DepartmentPOJO {
	
	private int departmentId;
	private String departmentName;
	private List<EmployeePOJO> employeePojo;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<EmployeePOJO> getEmployeePojo() {
		return employeePojo;
	}
	public void setEmployeePojo(List<EmployeePOJO> employeePojo) {
		this.employeePojo = employeePojo;
	}
	
	
	public DepartmentPOJO() {
		super();
	}
	public DepartmentPOJO(int departmentId, String departmentName, List<EmployeePOJO> employeePojo) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeePojo = employeePojo;
	}
	
	

}
