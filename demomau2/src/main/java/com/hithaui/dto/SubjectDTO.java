package com.hithaui.dto;

public class SubjectDTO {
	
	
	private String subjectCode;
	
	private String name;

	public SubjectDTO() {
		super();
	}

	public SubjectDTO(String subjectCode, String name) {
		super();
		this.subjectCode = subjectCode;
		this.name = name;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
