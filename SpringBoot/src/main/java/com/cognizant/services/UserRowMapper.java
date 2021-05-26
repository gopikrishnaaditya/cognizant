package com.cognizant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



import com.cognizant.beans.User;

public class UserRowMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User u = new User();
		u.setId(rs.getInt(1));
		u.setName(rs.getString(2));
		
            
		return u;
	}

}
