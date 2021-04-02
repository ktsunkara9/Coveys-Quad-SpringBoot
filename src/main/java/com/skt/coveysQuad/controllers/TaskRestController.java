package com.skt.coveysQuad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skt.coveysQuad.entities.Task;
import com.skt.coveysQuad.exceptions.TaskErrorResponse;
import com.skt.coveysQuad.exceptions.TaskNotFoundException;
import com.skt.coveysQuad.services.TaskService;

@CrossOrigin
@RestController
public class TaskRestController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getTasks();
	}

	@GetMapping("/tasks/{id}")
	public Task getTask(@PathVariable Integer id) {
		return taskService.getTask(id);
	}

	@PostMapping("/tasks")
	public void addTask(@RequestBody Task task) {
		taskService.addTask(task);
	}

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
