package com.test.repository;


import org.springframework.data.repository.CrudRepository;

import com.test.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department , Integer> {
	
	
}
