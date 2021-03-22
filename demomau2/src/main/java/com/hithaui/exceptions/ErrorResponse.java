package com.hithaui.exceptions;

public class ErrorResponse {
	
	
	private Integer sataus;
	
	private String message;
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(Integer sataus, String message) {
		super();
		this.sataus = sataus;
		this.message = message;
	}

	public Integer getSataus() {
		return sataus;
	}

	public void setSataus(Integer sataus) {
		this.sataus = sataus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
