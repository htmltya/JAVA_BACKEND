package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.Student;
import com.hithaui.dao.StudentSubject;
import com.hithaui.dao.Subject;
import com.hithaui.dto.StudentSubjectDTO;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.StudentRepository;
import com.hithaui.repositories.StudentSubjectRepository;
import com.hithaui.repositories.SubjectRepository;

@RestController
@RequestMapping("/api/studentsubject")
public class StudentSubjectController {
	
	
		@Autowired
		private StudentRepository studentRepository;
		
		@Autowired
		private SubjectRepository subjectRepository;
		
		@Autowired
		private StudentSubjectRepository studentSubjectRepository;
		
		
		@GetMapping
		public ResponseEntity<?> findAllStudentSubject()
		{
			List<StudentSubject> list = studentSubjectRepository.findAll();
			
			if (list.size() == 0) 
			{
				throw new NotFoundException("No conten");
				
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		@GetMapping("/{studentSubjectID}")
		public ResponseEntity<?> findStudentSubjectByID(@PathVariable("studentSubjectID") Integer studentSubjectID) {
			
			Optional<StudentSubject> studentSubject =  studentSubjectRepository.findById(studentSubjectID);
			if(!studentSubject.isPresent()) {
				throw new NotFoundException("Not found StudentSubject by studentSubjectID: "+ studentSubjectID);
			}
			return ResponseEntity.status(HttpStatus.OK).body(studentSubject.get());
		}
		
		@PostMapping
		public ResponseEntity<?> createNewStudenSubject(@RequestBody StudentSubjectDTO studentSubjectDTO)
		{
			Optional<Student> student = studentRepository.findById(studentSubjectDTO.getStudentID());
			Optional<Subject> subject = subjectRepository.findById(studentSubjectDTO.getSubjectID());
			
			if( !student.isPresent()) {
					throw new NotFoundException("Not found StudentID: "+ studentSubjectDTO.getStudentID());
			}
			
			if (!subject.isPresent()) {
				throw new NotFoundException("No found SubjectID: "+ studentSubjectDTO.getSubjectID());
			}
			
			StudentSubject studentSubject = new StudentSubject();
			studentSubject.setStudent(student.get());
			studentSubject.setSubject(subject.get());
			StudentSubject newStudentSubject = studentSubjectRepository.save(studentSubject);
			return ResponseEntity.status(HttpStatus.OK).body(newStudentSubject);
		}
		
		@PatchMapping("/{studentSubjectID}")
		public ResponseEntity<?> editStudentSubjectById(@PathVariable("studentSubjectID") Integer studentSubjectID,
			@RequestBody StudentSubjectDTO studentSubjectDTO) {
			
			Optional<StudentSubject> oldstudentSubject =  studentSubjectRepository.findById(studentSubjectID);
			if(!oldstudentSubject.isPresent()) {
					throw new NotFoundException("Not found StudentSubject by studentSubjectID: "+ studentSubjectID);
			}
			
			Optional<Student> student = studentRepository.findById(studentSubjectDTO.getStudentID());
			Optional<Subject> subject = subjectRepository.findById(studentSubjectDTO.getSubjectID());
			if( !student.isPresent()) {
					throw new NotFoundException("Not found StudentID: "+ studentSubjectDTO.getStudentID());
			}
		
			if (!subject.isPresent()) {
					throw new NotFoundException("No found SubjectID: "+ studentSubjectDTO.getSubjectID());
			}
			
			
			StudentSubject studentSubject = oldstudentSubject.get();
			studentSubject.setStudent(student.get());
			studentSubject.setSubject(subject.get());
			StudentSubject newStudentSubject = studentSubjectRepository.save(studentSubject);
			return ResponseEntity.status(HttpStatus.OK).body(newStudentSubject);
			
		}
		
		
		@DeleteMapping("/{studentSubjectID}")
		public ResponseEntity<?> deleteStudentSubject(@PathVariable("studentSubjectID") Integer studenSubjectID)
		{
			Optional<StudentSubject> studentSubject = studentSubjectRepository.findById(studenSubjectID);
			
			if (!studentSubject.isPresent()) {
					throw new NotFoundException("Not found studentSubjectID: "+ studenSubjectID);
			}
			studentSubjectRepository.deleteById(studenSubjectID);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
}
