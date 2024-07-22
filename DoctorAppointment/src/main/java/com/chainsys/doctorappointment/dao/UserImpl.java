package com.chainsys.doctorappointment.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.doctorappointment.mapper.AddMapper;
import com.chainsys.doctorappointment.mapper.AppointmentMapping;
import com.chainsys.doctorappointment.mapper.DoctorMapping;
import com.chainsys.doctorappointment.mapper.UserMapping;
import com.chainsys.doctorappointment.model.AppoitmentBook;
import com.chainsys.doctorappointment.model.Doctor;
import com.chainsys.doctorappointment.model.User;

@Repository
public class UserImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void doctorregistration(User userDetails) {
		String query = "insert into user_details(user_profile,user_name,user_mailId,user_password,user_specialization) values (?,?,?,?,?) ";
		Object[] params = { userDetails.getProfile(), userDetails.getUsername(), userDetails.getMailid(),
				userDetails.getPassword(),userDetails.getType() };
		int rows = jdbcTemplate.update(query, params);
	}
	
	public void doctorupdate(User userDetails) {
		String query = "update user_details set user_name=?,user_mailId=?,user_password=? where user_mailId=? ";
		System.out.println();
		Object[] params = { userDetails.getUsername(), userDetails.getMailid(), userDetails.getPassword(),
				userDetails.getGetmail() };
		int rows = jdbcTemplate.update(query, params);
	}
	
	
//	---------------patient side
	
	public void patientregistration(User userDetails) {
		String query = "insert into user_details(user_profile,user_name,user_mailId,user_password) values (?,?,?,?)";
		Object[] params = { userDetails.getProfile(), userDetails.getUsername(), userDetails.getMailid(),
				userDetails.getPassword()};
		int rows = jdbcTemplate.update(query, params);
	}

	
	public void patientupdate(User userDetails) {
		String query = "update user_details set user_name=?,user_mailId=?,user_password=? where user_mailId=? ";
		System.out.println();
		Object[] params = { userDetails.getUsername(), userDetails.getMailid(), userDetails.getPassword(),
				userDetails.getGetmail() };
		int rows = jdbcTemplate.update(query, params);
	}
	
	

	public boolean login(User userDetails) {

		String query = "select * from user_details where user_mailId=? and user_password=? and user_profile=?";

		try {

			User rows = jdbcTemplate.queryForObject(query, new UserMapping(), userDetails.getMailid(),
					userDetails.getPassword(), userDetails.getProfile());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	
	
	public List<User> adminview() {
		
		String query="select * from user_details";
		List<User> user =jdbcTemplate.query(query, new UserMapping());
		return  user;
	}


	public User view(User userDetails) {

		String query = "select * from user_details where user_mailId=?";
		User user = jdbcTemplate.queryForObject(query, new UserMapping(), userDetails.getMailid());
		return user;
	}

	public String userview(User user) {

		String query = "select user_specialization from user_details where user_mailId=?";
		return jdbcTemplate.queryForObject(query, new DoctorMapping(), user.getMailid());
	}

	public void appointmentbooking(AppoitmentBook booking) {
		String query = "insert into appointment_details(id,user_name,user_mailid,doctor_specialization,appointment_date,appointment_time) values (?,?,?,?,?,?) ";
		Object[] params = { booking.getUserId(), booking.getAppointUser(), booking.getAppointMailId(),
				booking.getAppointDisease(), booking.getAppointDate(), booking.getAppointTime() };
		int rows = jdbcTemplate.update(query, params);
	}

	public List<AppoitmentBook> doctorview(String specs) {
		String query = "select appointment_id,user_name,user_mailid,appointment_date,appointment_time from appointment_details where doctor_specialization=?";
		List<AppoitmentBook> list = jdbcTemplate.query(query, new AppointmentMapping(), specs);
		if(list!=null) {
		return list;}
		return null;
	}

	public void doctorinsert(User userDetails) {
		String query = "insert into doctor_details(doctor_mailId,doctor_name,doctor_specialization,doctor_image,profile) values (?,?,?,?,?) ";
		Object[] params = { userDetails.getMailid(),userDetails.getUsername(),userDetails.getType(),userDetails.getImage(),userDetails.getProfile()};
		int rows = jdbcTemplate.update(query, params);
	}
	


	public List<User> add(String profile) {

		String query = "select user_id,user_mailId,user_name,user_specialization from user_details where user_profile=?";
		return (List<User>) jdbcTemplate.query(query, new AddMapper() , profile);

	}


}