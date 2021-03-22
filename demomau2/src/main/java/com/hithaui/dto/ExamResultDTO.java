package com.hithaui.dto;

public class ExamResultDTO {

	private Integer studentSubjectID;
	
	private float mark;
	
	private float reMark;

	
	public ExamResultDTO() {
		super();
	}


	public ExamResultDTO(Integer studentSubjectID, float mark, float reMark) {
		super();
		this.studentSubjectID = studentSubjectID;
		this.mark = mark;
		this.reMark = reMark;
	}


	public Integer getStudentSubjectID() {
		return studentSubjectID;
	}


	public void setStudentSubjectID(Integer studentSubjectID) {
		this.studentSubjectID = studentSubjectID;
	}


	public float getMark() {
		return mark;
	}


	public void setMark(float mark) {
		this.mark = mark;
	}


	public float getReMark() {
		return reMark;
	}


	public void setReMark(float reMark) {
		this.reMark = reMark;
	}
	
	
	
	
}
