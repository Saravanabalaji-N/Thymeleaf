package com.chainsys.doctorappointment.model;

import org.springframework.stereotype.Component;

@Component
public class AppoitmentBook {

	String userId;
	String appointId;
	String appointUser;
	String appointMailId;
	String appointDisease;
	String appointTime;
	String appointDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAppointId() {
		return appointId;
	}
	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}
	public String getAppointUser() {
		return appointUser;
	}
	public void setAppointUser(String appointUser) {
		this.appointUser = appointUser;
	}
	public String getAppointMailId() {
		return appointMailId;
	}
	public void setAppointMailId(String appointMailId) {
		this.appointMailId = appointMailId;
	}
	public String getAppointDisease() {
		return appointDisease;
	}
	public void setAppointDisease(String appointDisease) {
		this.appointDisease = appointDisease;
	}
	public String getAppointTime() {
		return appointTime;
	}
	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}
	public String getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}
	
	
}
