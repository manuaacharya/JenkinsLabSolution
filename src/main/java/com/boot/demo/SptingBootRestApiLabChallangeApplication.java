package com.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.boot.demo.pojo.Employee;
import com.boot.demo.repo.EmployeeRepo;

@SpringBootApplication
public class SptingBootRestApiLabChallangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SptingBootRestApiLabChallangeApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepo emprepo;
	
	@Bean
	public void insertData() {
		
		System.out.println("Data Insertion to DB.....");
		Employee emp1 = new Employee(1,"Emp1","e1@gmail.com","IT");
		Employee emp2 = new Employee(2,"Emp2","e2@gmail.com","ADMIN");
		Employee emp3 = new Employee(3,"Emp3","e3@gmail.com","HR");
		Employee emp4 = new Employee(4,"Emp4","e4@gmail.com","GM");
		Employee emp5 = new Employee(5,"Emp5","e5@gmail.com","CEO");
		
		emprepo.save(emp1);
		emprepo.save(emp2);
		emprepo.save(emp3);
		emprepo.save(emp4);
		emprepo.save(emp5);
	}
	
}
