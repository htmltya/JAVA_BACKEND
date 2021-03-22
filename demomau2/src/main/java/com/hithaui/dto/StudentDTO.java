package com.hithaui.dto;

public class StudentDTO {
	
	
	private String studentCode;
	
	private String fullName;
	
	private String phone;

	public StudentDTO() {
		super();
	}

	public StudentDTO(String studentCode, String fullName, String phone) {
		super();
		this.studentCode = studentCode;
		this.fullName = fullName;
		this.phone = phone;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
