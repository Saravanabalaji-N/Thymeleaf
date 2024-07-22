package com.chainsys.doctorappointment.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.doctorappointment.model.User;

public class UserMapping implements RowMapper<User> {


	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String id=rs.getString("user_id");
		String profile=rs.getString("user_profile");
		String image=rs.getString("user_image");
		String name=rs.getString("user_name");
		String mail=rs.getString("user_mailId");
		String pass=rs.getString("user_password");
		String type=rs.getString("user_specialization");
	
		User details=new User();
		details.setId(id);
		details.setProfile(profile);
		details.setUsername(name);
		details.setMailid(mail);
		details.setPassword(pass);
		details.setType(type);
		details.setImage(image);
		return details;
		
		
	}

}
