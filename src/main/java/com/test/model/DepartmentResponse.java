package com.test.model;

import java.util.List;

public class DepartmentResponse {
	
	private List<DepartmentPOJO> depPojo ;

	public List<DepartmentPOJO> getDepPojo() {
		return depPojo;
	}

	public void setDepPojo(List<DepartmentPOJO> depPojo) {
		this.depPojo = depPojo;
	}
	
	public DepartmentResponse() {
		super();
	}

	public DepartmentResponse(List<DepartmentPOJO> depPojo) {
		super();
		this.depPojo = depPojo;
	}
	
	

}
