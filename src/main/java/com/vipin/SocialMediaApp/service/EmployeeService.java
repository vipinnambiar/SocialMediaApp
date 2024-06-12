package com.vipin.SocialMediaApp.service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.vipin.SocialMediaApp.model.Employee;

@Service
public class EmployeeService {
	
	
	List<Employee> emp1 = new ArrayList<Employee>();
	
	public List<Employee> createEmployees()
	{
		emp1.add(new Employee(1,"Vipin","N"));
		emp1.add(new Employee(1,"Rock","Paper"));
		return (emp1);	
	}
	
	public List<Employee> getEmployeeList()
	{
		List<Employee> emp1 = new ArrayList<Employee>();	
		return (createEmployees());
	}
	
	
	
	public Optional<Employee> getEmployee(int id)
	{
		return createEmployees().stream().filter(employee -> employee.getId() == id).findFirst();
		
	}

}
