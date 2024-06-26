package com.vipin.SocialMediaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vipin.SocialMediaApp.model.Employee;
import com.vipin.SocialMediaApp.service.EmployeeService;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;


@RestController
//@RequestMapping(value ="/employee") // Used primarily of Defining the context path
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	//RequestMapping is not ideal recommendation for readability, use @getmapping ,@postmapping @deletemapping etc
	@RequestMapping(path="/employees/list",method=RequestMethod.GET, produces = "application/json")
	public List<Employee> getEmployeeList()
	{
		return empService.getEmployeeList();
	}

	@GetMapping(path="/employee/{id}", produces = "application/json")
	public Employee getEmployee(@PathVariable int id)
	{
		return empService.getEmployee(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found"));
	}
	
	
	@PostMapping(path="/employee/add",consumes ="application/json")
	public ResponseEntity addEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity(" Employee Created Successfully ",HttpStatus.OK);
	}
	
	/*
	 * 
	 * 
	 */

}
