package com.airlines.model;

public class AuthResponse {
	private String userName;
	private String emailId;
	private boolean authenticationStatus;
	private boolean admin;
	public AuthResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isAuthenticationStatus() {
		return authenticationStatus;
	}
	public void setAuthenticationStatus(boolean authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public AuthResponse(String userName, String emailId, boolean authenticationStatus) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.authenticationStatus = authenticationStatus;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	

}
