package com.chainsys.doctorappointment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.doctorappointment.model.AppoitmentBook;



public class AppointmentMapping implements RowMapper<AppoitmentBook>{

	@Override
	public AppoitmentBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        
		String appointmentid=rs.getString("appointment_id");
		String name=rs.getString("user_name");
		String mail=rs.getString("user_mailid");
//		String specs=rs.getString("doctor_specialization");
		String date=rs.getString("appointment_date");
		String time=rs.getString("appointment_time");
		
		AppoitmentBook booking=new AppoitmentBook();
		booking.setAppointId(appointmentid);
		booking.setAppointUser(name);
		booking.setAppointMailId(mail);
//		booking.setAppointDisease(specs);
		booking.setAppointDate(date);
		booking.setAppointTime(time);
		
		return booking;
	}

	

}
