package com.chainsys.doctorappointment.dao;

import java.util.List;

import com.chainsys.doctorappointment.model.AppoitmentBook;
import com.chainsys.doctorappointment.model.Doctor;
import com.chainsys.doctorappointment.model.User;

public interface  UserDao {
	
//	--------doctor side------
	
	public void doctorregistration(User userDetails) ;
	
	public void doctorupdate(User userDetails);
	
//	--------patient side------
	
	public void patientregistration(User userDetails) ;

	public void patientupdate(User userDetails);
	
//----------------admin side-------------
	
	public List<User> adminview() ;
	
//	---------login
	
	public boolean login(User userDetails) ;
	

	public User view(User userDetails) ;
	
	public void appointmentbooking(AppoitmentBook booking);
	
	public List<AppoitmentBook> doctorview(String specs);
	
	public String userview(User user);
	
	public void doctorinsert(User userDetails);
	
	public List<User> add(String profile);

	
}

