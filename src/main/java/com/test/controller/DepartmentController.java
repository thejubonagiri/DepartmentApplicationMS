package com.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Department;
import com.test.entity.Employee;
import com.test.model.DepartmentPOJO;
import com.test.model.DepartmentRequest;
import com.test.model.DepartmentResponse;
import com.test.model.EmployeePOJO;
import com.test.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	
	@GetMapping(value = "/departments" )
	public DepartmentResponse getAllDepartmentDetails ()
	{
		List<Department> getAllDepDetails = service.getAllDepartmentDetails();
		
		List<DepartmentPOJO> departmentPojo = new ArrayList<>();
		
		for(Department dep : getAllDepDetails )
		{
			List<EmployeePOJO> employeePojos = new ArrayList<>();
			for(Employee emp : dep.getEmployees())	
			{
				employeePojos.add( new EmployeePOJO(emp.getEmployeeId(), emp.getEmployeeName(), emp.getAddress()));
			}
				
			DepartmentPOJO depPojo = new DepartmentPOJO(dep.getDepartmentId(), dep.getDepartmentName() ,employeePojos);
			departmentPojo.add(depPojo);
		}
			
		return new DepartmentResponse(departmentPojo);
	}
	
	@PostMapping(value = "/departments" )
	public DepartmentResponse createDepartmentDetails (@RequestBody DepartmentRequest departmentRequest)
	{   List<Employee> employees = new ArrayList<>();
		List<EmployeePOJO> empPOJO = new ArrayList<>() ;
		
		Department department = new Department(departmentRequest.getDepartmentPojo().getDepartmentId(), departmentRequest.getDepartmentPojo().getDepartmentName(),employees);
		Department createDepartment = service.createDepartmentDetails(department);
		
		if(createDepartment!=null)
		{
			for(Employee emp : createDepartment.getEmployees())
			{
				empPOJO.add(new EmployeePOJO(emp.getEmployeeId(), emp.getEmployeeName(), emp.getAddress()));
			}
			DepartmentPOJO depPOJO = new DepartmentPOJO(createDepartment.getDepartmentId(), createDepartment.getDepartmentName(), empPOJO);
			
			return new DepartmentResponse(Arrays.asList(depPOJO));
			
		}
		
            return null;
	}
	
	@GetMapping(value = "/departments/{id}" )
	public DepartmentResponse getDepartmentbasedonId(@PathVariable("id")int departmentId)
	{
		List<EmployeePOJO> empPOJO = new ArrayList<>() ;
		Department dep = service.getDepartmentbasedonId(departmentId);
		for(Employee emp : dep.getEmployees())
		{
			empPOJO.add(new EmployeePOJO(emp.getEmployeeId(), emp.getEmployeeName(), emp.getAddress()));
		}
		DepartmentPOJO depPOJO = new DepartmentPOJO(dep.getDepartmentId(), dep.getDepartmentName(), empPOJO);
		
		return new DepartmentResponse(Arrays.asList(depPOJO));
	}
	
	@PutMapping(value = "/departments" )
	public DepartmentResponse updateDepartmentDetails(@RequestBody DepartmentRequest departmentRequest)
	{
		List<Employee> employees = new ArrayList<>();
		List<EmployeePOJO> empPOJO = new ArrayList<>() ;
		
		Department department = new Department(departmentRequest.getDepartmentPojo().getDepartmentId(), departmentRequest.getDepartmentPojo().getDepartmentName(), employees);
		Department dep = service.updateDepartmentDetails(department);
		if(dep!=null)
		{
			for(Employee emp : dep.getEmployees())
			{
				empPOJO.add(new EmployeePOJO(emp.getEmployeeId(), emp.getEmployeeName(), emp.getAddress()));
			}
			DepartmentPOJO depPOJO = new DepartmentPOJO(dep.getDepartmentId(),dep.getDepartmentName(), empPOJO);
			return new DepartmentResponse(Arrays.asList(depPOJO));
		}
		
		return null;
		
	}
	
	@DeleteMapping(value = "/departments/{id}" )
	public DepartmentResponse deleteDepartmentDetails(@PathVariable("id")int departmentId)
	{
		List<EmployeePOJO> empPOJO = new ArrayList<>() ;
		Department deleteDep = service.deleteDepartmentDetails(departmentId);
		for(Employee emp : deleteDep.getEmployees())
		{
			empPOJO.add(new EmployeePOJO(emp.getEmployeeId(), emp.getEmployeeName(), emp.getAddress()));
		}
		DepartmentPOJO depPOJO = new DepartmentPOJO(deleteDep.getDepartmentId(), deleteDep.getDepartmentName(), empPOJO);
		return new DepartmentResponse(Arrays.asList(depPOJO));
	}

}
