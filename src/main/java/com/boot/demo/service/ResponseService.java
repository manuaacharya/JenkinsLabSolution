package com.boot.demo.service;

public class ResponseService {
	
	private String message;
	private String description;
	
	public ResponseService() {
		// TODO Auto-generated constructor stub
	}
	public ResponseService(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}
	public String getMessage() {
		System.out.println("get message");
		return message;
	}
	public void setMessage(String message) {
		System.out.println("set message");
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
