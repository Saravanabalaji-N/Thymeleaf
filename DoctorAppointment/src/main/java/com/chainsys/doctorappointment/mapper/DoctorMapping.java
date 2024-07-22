package com.chainsys.doctorappointment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class DoctorMapping implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String specs=rs.getString("user_specialization");
		
		return specs;
	}

}
