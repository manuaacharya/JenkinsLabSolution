package com.boot.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.pojo.Employee;
import com.boot.demo.service.EmployeeService;
import com.boot.demo.service.ResponseService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eservice;
	
	public EmployeeController() {
		System.out.println("Employee Controller Invoked");
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(@RequestParam(required = false) Integer id) throws Exception{
		
		if(id==null) {
			return this.eservice.getAllEmployee();
		}
		return (List<Employee>) this.eservice.getemployeeById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable int id)
	{
		try {
			Employee emp = this.eservice.getemployeeById(id);
			return ResponseEntity
					.ok()
					.body(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ResponseService("failure", "employee with "+id+" doesn't exists"));
		}
	}
	
	@PostMapping
	public ResponseEntity<ResponseService> insertEMp(@RequestBody Employee emp)
	{
		System.out.println("inserting...");
		System.out.println(emp);
		if(this.eservice.insertEmployee(emp))
			return ResponseEntity
					.accepted()
					.body(new ResponseService("success", "employee with "+emp.getEid()+" inserted successfully"))
					;
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.body(new ResponseService("failure", "employee with "+emp.getEid()+" already exists"));
	}
	
	@PutMapping
	public ResponseEntity<ResponseService> updateEmployee(@RequestBody Employee emp)
	{
		if(this.eservice.updateEmployee(emp))
			return ResponseEntity
					.accepted()
					.body(new ResponseService("success", "employee with "+emp.getEid()+"updated successfully"))
					;
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.body(new ResponseService("failure", "employee with "+emp.getEid()+" can't able to update"));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseService> deleteBook(@PathVariable int id) throws Exception// path parameter
	{
		if(this.eservice.deleteById(id))
			return ResponseEntity
					.accepted()
					.body(new ResponseService("success", "employee with "+id+" deleted successfully"))
					;
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.body(new ResponseService("failure", "employee with "+id+" can't able to delete"));
	}
	
}
