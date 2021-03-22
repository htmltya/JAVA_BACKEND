package com.hithaui.utils;

import com.hithaui.dao.Student;
import com.hithaui.dao.Subject;
import com.hithaui.dto.StudentDTO;
import com.hithaui.dto.SubjectDTO;

public class ConvertObject {
	public static Student fromStudentDTOtoStudentDAO(StudentDTO studentDTO) {
		Student student = new Student();
		student.setStudentCode(studentDTO.getStudentCode());
		student.setPhone(studentDTO.getPhone());
		student.setFullName(studentDTO.getFullName());
		return student;
	}
	
	public static Subject fromSubjectDTOtoSubjectDAO(SubjectDTO subjectDTO)	{
		Subject subject = new Subject();
		subject.setSubjectCode(subjectDTO.getSubjectCode());
		subject.setName(subjectDTO.getName());
		return subject;
	}
	
	
}
