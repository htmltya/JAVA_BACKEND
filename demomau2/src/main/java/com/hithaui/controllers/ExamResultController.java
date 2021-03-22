package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hithaui.dao.ExamResult;
import com.hithaui.dao.StudentSubject;
import com.hithaui.dto.ExamResultDTO;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.ExamResultRepository;
import com.hithaui.repositories.StudentSubjectRepository;

@Controller
@RequestMapping("/api/examResult")
public class ExamResultController {
	
	
	@Autowired
	private ExamResultRepository examResultRepository;
	
	@Autowired
	private StudentSubjectRepository studentSubjectRepository;
	
	@GetMapping
	public ResponseEntity<?> findAllExamResult()	{
		List<ExamResult> ListExamResult = examResultRepository.findAll();
		if (ListExamResult.size() == 0) {
				throw new NotFoundException("Not have ExamResultd");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListExamResult);
	}
	
	@GetMapping("/{examResultId}")
	public ResponseEntity<?> findExamResultById(@PathVariable("examResultId") Integer examResultId ) {
		Optional<ExamResult> examResult=  examResultRepository.findById(examResultId);
		
		if (!examResult.isPresent()) {
				throw new NotFoundException("Not found examResultId:"+examResultId);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(examResult.get());
	}
	
	@PostMapping
	public ResponseEntity<?> createNewExamResult(@RequestBody ExamResultDTO examResultDTO) {
		
		Optional<StudentSubject> studenSubject = studentSubjectRepository.findById(examResultDTO.getStudentSubjectID());
		
		if( !studenSubject.isPresent()) {
				throw new NotFoundException("Not found by studenSubjectId: "+ examResultDTO.getStudentSubjectID());
		}
		
		ExamResult examResult = new ExamResult();
		examResult.setStudentSubject(studenSubject.get());
		examResult.setMark(examResultDTO.getMark());
		examResult.setReMark(examResultDTO.getReMark());
		
		ExamResult newExamResult = examResultRepository.save(examResult);
		
		return ResponseEntity.status(HttpStatus.OK).body(newExamResult);
		
	}
	@PatchMapping("/{examResultId}")
	public ResponseEntity<?> editExamResultById(@PathVariable("examResultId") Integer examResultId, 
			@RequestBody ExamResultDTO examResultDTO) {
		Optional<ExamResult> oldexamResult=  examResultRepository.findById(examResultId);
		
		if (!oldexamResult.isPresent()) {
				throw new NotFoundException("Not found examResultId:" + examResultId);
		}
		
		Optional<StudentSubject> studenSubject = studentSubjectRepository.findById(examResultDTO.getStudentSubjectID());
		
		if( !studenSubject.isPresent()) {
				throw new NotFoundException("Not found by studenSubjectId: "+ examResultDTO.getStudentSubjectID());
		}
		
		ExamResult examResult = new ExamResult();
		examResult.setStudentSubject(studenSubject.get());
		
		if (examResultDTO.getMark() > 0 ) {
				examResult.setMark(examResultDTO.getMark());
		}
		
		if (examResultDTO.getReMark() > 0 ) {
			examResult.setReMark(examResultDTO.getReMark());
		}
		
		
		ExamResult newExamResult = examResultRepository.save(examResult);
		
		return ResponseEntity.status(HttpStatus.OK).body(newExamResult);
		
	}
	
	@DeleteMapping("/{examResultId}")
	public ResponseEntity<?> deleteExamResultById(@PathVariable("examResultId") Integer examResultId) {
		Optional<ExamResult> examResult=  examResultRepository.findById(examResultId);
		
		if (!examResult.isPresent()) {
				throw new NotFoundException("Not found examResultId:"+examResultId);
		}
		
		examResultRepository.deleteById(examResultId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
