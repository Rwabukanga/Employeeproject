package com.EmployeeManagementSystem.employeemanagementsystem.Exception;

import java.util.Date;

public class ErrorMessage {
	
	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;
	
	
	  public static int InvalidName=602;
	  public static int InvalidPhone=604;
	  public static int InvalidEmail=605;
	  public static int InvalidDateofBirth=606;
	  public static int InvalidNationalID=607;
	 
	
	
	 
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
		super();
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static int getInvalidName() {
		return InvalidName;
	}
	public static void setInvalidName(int invalidName) {
		InvalidName = invalidName;
	}
	public static int getInvalidPhone() {
		return InvalidPhone;
	}
	public static void setInvalidPhone(int invalidPhone) {
		InvalidPhone = invalidPhone;
	}
	public static int getInvalidEmail() {
		return InvalidEmail;
	}
	public static void setInvalidEmail(int invalidEmail) {
		InvalidEmail = invalidEmail;
	}
	public static int getInvalidDateofBirth() {
		return InvalidDateofBirth;
	}
	public static void setInvalidDateofBirth(int invalidDateofBirth) {
		InvalidDateofBirth = invalidDateofBirth;
	}
	public static int getInvalidNationalID() {
		return InvalidNationalID;
	}
	public static void setInvalidNationalID(int invalidNationalID) {
		InvalidNationalID = invalidNationalID;
	}
	
	
	
	@Override
	public String toString() {
		return "ErrorMessage [statusCode=" + statusCode + ", timestamp=" + timestamp + ", message=" + message
				+ ", description=" + description + "]";
	}
	
	
	
	
	
	
	

}
