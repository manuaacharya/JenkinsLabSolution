package com.boot.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.boot.demo.pojo.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{

	
}
