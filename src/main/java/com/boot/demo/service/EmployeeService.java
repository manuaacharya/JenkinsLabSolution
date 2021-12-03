package com.boot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.demo.pojo.Employee;
import com.boot.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	public boolean insertEmployee(Employee emp) {
		if(this.emprepo.existsById(emp.getEid()))
		{
			return false;
		}
		this.emprepo.save(emp);
		return true;
	}
	
	public Employee getemployeeById(int id) throws Exception {
		return
		this.emprepo.findById(id).orElseThrow(()-> new Exception("book id dosen't exist"));
	}
	
	public boolean deleteById(int id) throws Exception{
		try {
		this.emprepo.deleteById(id);
		}
		catch(Exception e)
		{
			throw new Exception("Could not delete employee with id "+id);
		}
		System.out.println("Deleted");
		return true;
	}
	
	public boolean updateEmployee(Employee emp)
	{
		if(!this.emprepo.existsById(emp.getEid()))
		{
			return false;
		}
		this.emprepo.save(emp);
		return true;
	}
	
	public List<Employee> getAllEmployee()
	{
		List<Employee> list = new ArrayList<>();
		this.emprepo.findAll().forEach(book-> list.add(book));
		return list;
	}
	
}
