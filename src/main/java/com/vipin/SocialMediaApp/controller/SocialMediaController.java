package com.vipin.SocialMediaApp.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;
import java.util.ArrayList;

import com.vipin.SocialMediaApp.exception.UserNotFoundException;
import com.vipin.SocialMediaApp.model.User;
import com.vipin.SocialMediaApp.service.UserService;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.validation.Valid;
import jakarta.websocket.server.ServerApplicationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController("/SocialMedia")
public class SocialMediaController {

	@Autowired
	private  UserService userService;
	
@GetMapping(value="users/list")
public ResponseEntity<List<User>> getUserList()
{
	List<User> usrlist = userService.userList;
	return ResponseEntity.ok(usrlist); // static method that returns 201 with body as passed in the argument
}

@GetMapping(value="user/{id}")
public ResponseEntity<User> getUserList(@PathVariable Integer id)
{
	User usr = userService.getUserbyId(id);

    if (usr == null)
    	throw new UserNotFoundException(" User not found - "+id);
	return new ResponseEntity<User>(usr,HttpStatus.OK);
}

@PostMapping(value="user/create")
public ResponseEntity<User> createUser(@Valid @RequestBody User user)
{  
	User usr = userService.createUser(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usr.getId()).toUri();
   return ResponseEntity.created(location).build();
}

@DeleteMapping(value="user/delete/{id}")
public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Integer id)
{  
	
	StringBuffer sb;
	ResponseMessage respmsg=null;
	if (userService.deleteUser(id)==1)
	{
		respmsg = new ResponseMessage(" User deleted Successfully "+id);
	}
	else 
		throw new UserNotFoundException("user not deleted "+id);
	
	return  ResponseEntity.ok(respmsg);
}

}
