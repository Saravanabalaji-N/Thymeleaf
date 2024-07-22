package com.chainsys.doctorappointment.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.doctorappointment.model.User;



public class AddMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id=rs.getString("user_id");
		String name=rs.getString("user_name");
		String mail=rs.getString("user_mailId");
		String specalization=rs.getString("user_specialization");
		
		User user=new User();
		user.setUsername(name);
		user.setMailid(mail);
		user.setType(specalization);
	
		user.setId(id);
		return user;
	}

}
