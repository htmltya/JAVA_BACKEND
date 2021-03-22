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

import com.hithaui.dao.Subject;
import com.hithaui.dto.SubjectDTO;
import com.hithaui.exceptions.DuplicateRecordException;
import com.hithaui.exceptions.NotFoundException;
import com.hithaui.repositories.SubjectRepository;
import com.hithaui.utils.ConvertObject;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
		
		@Autowired
		private SubjectRepository subjectRepository;
		
		
		@GetMapping
		public ResponseEntity<?> findAllSubject() {
				List<Subject> listSubjects = subjectRepository.findAll();
				
				if(listSubjects.size() == 0) {
							throw new NotFoundException("There are no subjects");
				}
				return ResponseEntity.status(HttpStatus.OK).body(listSubjects);
		}
		
		
		@GetMapping("/{subjectId}")
		public ResponseEntity<?> getSubjectById(@PathVariable("subjectId") Integer subjectId) {
				Optional<Subject> subject = subjectRepository.findById(subjectId);
				
				if(!subject.isPresent()) {
						throw new NotFoundException("Not found subject by subjectId : "+ subjectId);
				}
				return ResponseEntity.status(HttpStatus.OK).body(subject.get());
		}
		
		@PostMapping
		public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
				Subject oldSubject =  subjectRepository.findBySubjectCode(subjectDTO.getSubjectCode());
				
				if(oldSubject != null ) {
							throw new DuplicateRecordException("Duplicate record student");
				}
				
				Subject subject = ConvertObject.fromSubjectDTOtoSubjectDAO(subjectDTO);
				Subject newSubject = subjectRepository.save(subject);
				return ResponseEntity.status(HttpStatus.OK).body(newSubject);
		}
			
		@PatchMapping("/{subjectId}")
		public ResponseEntity<?> setSubjectById(@PathVariable("subjectId")  Integer subjectId,
								@RequestBody SubjectDTO subjectDTO)	{
				Optional<Subject> optional = subjectRepository.findById(subjectId);
				
				if(!optional.isPresent()) {
						throw new NotFoundException("Not found subject by subjectId : "+ subjectId);
				}
				
				Subject subject = optional.get();
				
				if(subjectDTO.getSubjectCode() != null) {
						subject.setSubjectCode(subjectDTO.getSubjectCode());
				}
				
				if(subjectDTO.getName() != null) {
						subject.setName(subjectDTO.getName());
				}
				
				Subject  newSubject= subjectRepository.save(subject);
				return ResponseEntity.status(HttpStatus.OK).body(newSubject);
		}
		
		@DeleteMapping("/{subjetId}")
		public ResponseEntity<?> deleteSubjectById(@PathVariable("subjectId")  Integer subjectId) {
				
				Optional<Subject> subject = subjectRepository.findById(subjectId);
				
				if(!subject.isPresent()) {
						throw new NotFoundException("Not found subject by subjectId : "+ subjectId);
				}
				subjectRepository.deleteById(subjectId);
				
				return ResponseEntity.status(HttpStatus.OK).build();
		}	
}
