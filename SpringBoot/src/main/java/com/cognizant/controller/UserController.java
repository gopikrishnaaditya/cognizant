package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.beans.User;
import com.cognizant.exception.UserNotFoundException;
import com.cognizant.services.GetUserService;

@CrossOrigin
@RestController
public class UserController {
	

	@RequestMapping(method = RequestMethod.GET, value= "/login")
	public ResponseEntity<String> login() {
		
		System.out.println("Hi");
		
		return new ResponseEntity<String>("Login Sucessfull", HttpStatus.OK);
	}
	
	@Autowired
	GetUserService service;
	
	@RequestMapping(method = RequestMethod.GET, value= "/users")
	public ResponseEntity<List<User>> getUsers(){
		
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUsersByID(@PathVariable("id") int id) throws UserNotFoundException{
		
		return new ResponseEntity<User>(service.getUsersByID(id), HttpStatus.OK);
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addUser")
	public ResponseEntity<String> signUp(@RequestBody User user)throws UserNotFoundException
	{
		if(service.addUser(user))
			return new ResponseEntity<String>("added Successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Not added Successfully",HttpStatus.NOT_FOUND);
	}

}
