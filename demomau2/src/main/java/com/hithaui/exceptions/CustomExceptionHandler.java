package com.hithaui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class CustomExceptionHandler {
		
		@ExceptionHandler(NotFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public ErrorResponse handleNotFoundExcption(NotFoundException ex, WebRequest req) {
				return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		}
		
		@ExceptionHandler(DuplicateRecordException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorResponse handleDuplicateRecordException(DuplicateRecordException ex, WebRequest req) {
				return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		}
		
}
	
