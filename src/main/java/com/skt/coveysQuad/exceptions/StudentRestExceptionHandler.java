package com.skt.coveysQuad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleTaskNotFoundException(TaskNotFoundException e) {
		TaskErrorResponse error = new TaskErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<TaskErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleTaskNotFoundException(Exception e) {
		TaskErrorResponse err = new TaskErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMsg(e.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<TaskErrorResponse>(err, HttpStatus.BAD_REQUEST);
	}

}
