package com.test.model;

public class DepartmentRequest {
	
	private DepartmentPOJO departmentPojo;

	public DepartmentPOJO getDepartmentPojo() {
		return departmentPojo;
	}

	public void setDepartmentPojo(DepartmentPOJO departmentPojo) {
		this.departmentPojo = departmentPojo;
	}

	public DepartmentRequest() {
		super();
	}

	public DepartmentRequest(DepartmentPOJO departmentPojo) {
		super();
		this.departmentPojo = departmentPojo;
	}
	
}
