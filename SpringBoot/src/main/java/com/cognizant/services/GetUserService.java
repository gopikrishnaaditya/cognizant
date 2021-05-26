package com.cognizant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.beans.User;
import com.cognizant.exception.UserNotFoundException;
import com.cognizant.repository.UserDAO;

@Service
public class GetUserService {
		
	@Autowired
	UserDAO dao;
	
	public List<User> getUsers() {
	
		return dao.getUser();
		
	}


	public User getUsersByID(int id) throws UserNotFoundException {
		
		return dao.getUserByID(id);
	}
	
	public boolean addUser(User user) throws UserNotFoundException {
		
		return dao.addUser(user);
	}

}
