package com.hithaui.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Exam_Result")
public class ExamResult {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ExamResult_Id")
	private Integer examResultId;
	
	@Column(name = "Mark", nullable = false)
	private float mark;
	
	@Column(name = "reMark")
	private float reMark;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	
	@ManyToOne
	@JoinColumn(name = "StudentSubject_Id")
	private StudentSubject studentSubject;


	public ExamResult() {
		super();
	}


	public ExamResult(Integer examResultId, float mark, float reMark, Timestamp createAt, Timestamp updateAt,
			StudentSubject studentSubject) {
		super();
		this.examResultId = examResultId;
		this.mark = mark;
		this.reMark = reMark;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.studentSubject = studentSubject;
	}


	public Integer getExamResultId() {
		return examResultId;
	}


	public void setExamResultId(Integer examResultId) {
		this.examResultId = examResultId;
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


	public Timestamp getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}


	public Timestamp getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}


	public StudentSubject getStudentSubject() {
		return studentSubject;
	}


	public void setStudentSubject(StudentSubject studentSubject) {
		this.studentSubject = studentSubject;
	} 
	
	
	
}
