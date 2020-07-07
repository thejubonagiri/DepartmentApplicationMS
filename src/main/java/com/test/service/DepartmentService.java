package com.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Department;
import com.test.entity.Employee;
import com.test.model.EmployeePOJO;
import com.test.repository.DepartmentRepository;



@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	
	public List<Department> getAllDepartmentDetails()
	{
		List<Department> departments = new ArrayList<>();
		Iterator<Department> it = repository.findAll().iterator();
		
		while( it.hasNext() )
		{
			departments.add(it.next());
		}
		
		return departments;
	}
	
	public Department createDepartmentDetails(Department department)
	{
		 return repository.save(department);
		
	}
	
	
	public Department getDepartmentbasedonId(int departmentId)
	{
		return repository.findById(departmentId).orElse(null);
					
	}
	
	public Department updateDepartmentDetails(Department department)
	{
		return repository.save(department);
		
	}
	
	public Department deleteDepartmentDetails(int departmentId)
	{
		Department dep = repository.findById(departmentId).orElse(null);
		repository.deleteById(departmentId);
		return dep;
		
	}
	
	@PostConstruct
	public void fillDepartmentTable()
	{
		Department dep1 = new Department(11, "Sanitation" , Collections.<Employee>emptyList());
		Department dep2 = new Department(12, "Panchayat" , Collections.<Employee>emptyList());
		
		repository.save(dep1);
		repository.save(dep2);
	}

}
