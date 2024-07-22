package com.chainsys.doctorappointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.doctorappointment.dao.UserDao;
import com.chainsys.doctorappointment.model.AppoitmentBook;
import com.chainsys.doctorappointment.model.Doctor;
import com.chainsys.doctorappointment.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserDao userDAO;

	@Autowired
	User userDetails;

	@Autowired
	AppoitmentBook booking;

	@Autowired
	Doctor doctor;

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@PostMapping("/doctorregistration")
	public String doctorregistration(@RequestParam("username") String name, @RequestParam("profile") String profile,
			@RequestParam("mail") String mail, @RequestParam("pass") String pass, @RequestParam("repass") String repass,
			@RequestParam("type") String type) {

		System.out.println(name + mail + pass + type);

		if (pass.equals(repass)) {
			userDetails.setProfile(profile);
			userDetails.setUsername(name);
			userDetails.setMailid(mail);
			userDetails.setPassword(pass);
			userDetails.setType(type);
			userDAO.doctorregistration(userDetails);
		}

		return "index";
	}

	@PostMapping("/patientregistration")
	public String patientregistration(@RequestParam("username") String name, @RequestParam("profile") String profile,
			@RequestParam("mail") String mail, @RequestParam("pass") String pass,
			@RequestParam("repass") String repass) {

		if (pass.equals(repass)) {
			userDetails.setProfile(profile);
			userDetails.setUsername(name);
			userDetails.setMailid(mail);
			userDetails.setPassword(pass);
			userDAO.patientregistration(userDetails);
		}

		return "index";
	}

	@PostMapping("/patientupdate")
	public String patientupdate(@RequestParam("name") String name, @RequestParam("getmail") String getmail,
			@RequestParam("mail") String mail, @RequestParam("password") String pass, HttpServletRequest request) {
		HttpSession session = request.getSession();
		userDetails.setGetmail(getmail);
		userDetails.setUsername(name);
		userDetails.setMailid(mail);
		userDetails.setPassword(pass);

		userDAO.patientupdate(userDetails);
		session.setAttribute("mail", mail);
		User user = userDAO.view(userDetails);
		session.setAttribute("list", user);

		return "patient.jsp";
	}

	@PostMapping("/doctorupdate")
	public String doctorupdate(@RequestParam("name") String name, @RequestParam("getmail") String getmail,
			@RequestParam("mail") String mail, @RequestParam("password") String pass, HttpServletRequest request) {
		HttpSession session = request.getSession();
		userDetails.setGetmail(getmail);
		userDetails.setUsername(name);
		userDetails.setMailid(mail);
		userDetails.setPassword(pass);

		userDAO.doctorupdate(userDetails);
		session.setAttribute("mail", mail);
		User user = userDAO.view(userDetails);
		session.setAttribute("list", user);

		return "doctor.jsp";
	}

	@PostMapping("/login")
	public String registeration(@RequestParam("mail") String mail, @RequestParam("pass") String password,
			@RequestParam("profile") String profile, HttpServletRequest request, HttpServletResponse responses,
			Model model) {
		HttpSession session = request.getSession();
		userDetails.setProfile(profile);
		userDetails.setMailid(mail);
		userDetails.setPassword(password);

		System.out.println(profile + mail + password);

		if (profile.equals("Patient")) {
			if (userDAO.login(userDetails) == true) {
				session.setAttribute("mail", mail);
				User user = userDAO.view(userDetails);
				session.setAttribute("list", user);
				String profile1 = doctor.setProfile("Doctor");
				List<User> addlist = userDAO.add(profile1);
				session.setAttribute("add", addlist);
				return "patient";
			} else {

				return "index";
			}
		} else if (profile.equals("Doctor")) {
			if (userDAO.login(userDetails) == true) {
				session.setAttribute("mail", mail);
				User user = userDAO.view(userDetails);
				session.setAttribute("list", user);
				user.setMailid(mail);
				String Specs = userDAO.userview(user);
				List<AppoitmentBook> appointbooking = userDAO.doctorview(Specs);
				if (appointbooking != null) {
					session.setAttribute("view", appointbooking);
				} else {
					return "doctor";
				}
				return "doctor";
			}
		}
		return "index";
	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		session.invalidate();
		return "index";
	}

	@PostMapping("/booking")
	public String booking(@RequestParam("mail") String mail, @RequestParam("disease") String disease,
			@RequestParam("date") String date, @RequestParam("time") String time) {

		userDetails.setMailid(mail);
		User user = userDAO.view(userDetails);
		booking.setAppointUser(user.getUsername());
		booking.setAppointMailId(user.getMailid());
		booking.setUserId(user.getId());
		booking.setAppointDisease(disease);
		booking.setAppointDate(date);
		booking.setAppointTime(time);

		userDAO.appointmentbooking(booking);
		return "patient.jsp";
	}
}