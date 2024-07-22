package com.chainsys.doctorappointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.doctorappointment.dao.UserDao;
import com.chainsys.doctorappointment.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	UserDao userDAO;

	@Autowired
	User userDetails;

	@PostMapping("/admin")
	public String admin(HttpServletRequest reguest, HttpServletResponse response) {
		HttpSession session = reguest.getSession();
		List<User> list = userDAO.adminview();
		session.setAttribute("new", list);
		System.out.println("im here");
		return "admin";
	}

	@PostMapping("/Patient")
	public String patient(@RequestParam("profile") String name) {

		System.out.println(name + "11111111111111111");
		userDetails.setProfile(name);
		System.out.println(userDetails.getProfile());

		return "admin";
	}

	@PostMapping("/Doctor")
	public String doctor(@RequestParam("profile") String name) {
		System.out.println(name + "11111111111111111");
		userDetails.setProfile(name);
		return "admin";
	}
}
