package com.hithaui.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Subject_Id")
	private Integer subjectId;
	
	@Column(name = "Subject_Code", nullable = false, unique = true)
	private String subjectCode;
	
	@Nationalized
	@Column(name = "Name",nullable = false)
	private String name;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StudentSubject> listStudentSubjects;

	public Subject() {
		super();
	}

	public Subject(Integer subjectId, String subjectCode, String name, Timestamp createAt, Timestamp updateAt,
			List<StudentSubject> listStudentSubjects) {
		super();
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.name = name;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.listStudentSubjects = listStudentSubjects;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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

	public List<StudentSubject> getListStudentSubjects() {
		return listStudentSubjects;
	}

	public void setListStudentSubjects(List<StudentSubject> listStudentSubjects) {
		this.listStudentSubjects = listStudentSubjects;
	} 
	
	
}
