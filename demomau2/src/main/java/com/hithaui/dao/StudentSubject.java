package com.hithaui.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Student_Subject")
public class StudentSubject {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StudentSubject_Id")
	private Integer studentSubjectId;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	@ManyToOne
	@JoinColumn(name ="Student_Id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name ="Subject_Id")
	private Subject subject;
	

	@OneToMany(mappedBy = "studentSubject",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ExamResult> listExamResults;


	public StudentSubject() {
		super();
	}


	public StudentSubject(Integer studentSubjectId, Timestamp createAt, Timestamp updateAt, Student student,
			Subject subject, List<ExamResult> listExamResults) {
		super();
		this.studentSubjectId = studentSubjectId;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.student = student;
		this.subject = subject;
		this.listExamResults = listExamResults;
	}


	public Integer getStudentSubjectId() {
		return studentSubjectId;
	}


	public void setStudentSubjectId(Integer studentSubjectId) {
		this.studentSubjectId = studentSubjectId;
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


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public List<ExamResult> getListExamResults() {
		return listExamResults;
	}


	public void setListExamResults(List<ExamResult> listExamResults) {
		this.listExamResults = listExamResults;
	}


	
	
	
}
