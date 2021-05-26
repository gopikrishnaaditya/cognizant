package com.cognizant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.beans.User;
import com.cognizant.exception.UserNotFoundException;
import com.cognizant.services.UserRowMapper;


@Repository
public class UserDAO {

	public 
	@Autowired 
	JdbcTemplate jdbcTemplete;

	public List<User> getUser(){

		return jdbcTemplete.query("select id,name from users", new UserRowMapper());

	}

	public User getUserByID(int id) throws UserNotFoundException {
		
		String sql = "select id,name from users where id = ?";
		User user;
		try {
			user = jdbcTemplete.queryForObject(sql,new UserRowMapper(),new Object[]{id});
		}
		catch(Exception e) {
			throw new UserNotFoundException("User id " +id+" does not exist"); 
		}
		return user;

	}
public boolean addUser(User user) throws UserNotFoundException {
	String sql="insert into users values(?,?,'123','male')";
	try
	{
		return jdbcTemplete.update(sql,user.getName(),user.getId())>0;
	}
	catch(DataAccessException e)
	{
		throw new UserNotFoundException("Userid already available");
	}

	}
}
