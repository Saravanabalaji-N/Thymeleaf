package com.chainsys.doctorappointment.model;

import org.springframework.stereotype.Component;

@Component
public class User {


	String id;
	String profile;
	String username;
	String mailid;
	String password;
	String repassword;
	String getmail;
	String phoneno;
	String dob;
	String image;
	String type;
	
	
	
	public String getGetmail() {
		return getmail;
	}
	public void setGetmail(String getmail) {
		this.getmail = getmail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	public User(String username, String mailid, String password, String repassword) {
		super();
		this.username = username;
		this.mailid = mailid;
		this.password = password;
		this.repassword = repassword;
	}
	public User() {
		
}
}